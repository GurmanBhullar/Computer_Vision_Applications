package com.example.cvpr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Circle extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {


    CameraBridgeViewBase cameraBridgeViewBase;

    Mat mat;
    Mat grey;
    Mat cannyedge;



    private BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {

            super.onManagerConnected(status);

            switch (status){
                case LoaderCallbackInterface.SUCCESS: {
                    cameraBridgeViewBase.enableView();
                    break;
                }
                default:{
                    super.onManagerConnected(status);
                    break;
                }}
        }

        @Override
        public void onPackageInstall(int operation, InstallCallbackInterface callback) {
            super.onPackageInstall(operation, callback);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        cameraBridgeViewBase = (JavaCameraView) findViewById(R.id.circleView);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(this);
    }



    @Override
    protected void onResume() {
        super.onResume();

        if(!OpenCVLoader.initDebug()){
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
        }

        else
        {
            baseLoaderCallback.onManagerConnected(baseLoaderCallback.SUCCESS);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(cameraBridgeViewBase!=null){
            cameraBridgeViewBase.disableView();
        }
    }

    @Override
    protected void onDestroy() { super.onDestroy();
        //if (cameraBridgeViewBase != null) {
        //   cameraBridgeViewBase.disableView();
    }





    @Override
    public void onCameraViewStarted(int width, int height) {
        mat = new Mat(width,height, CvType.CV_8UC3);
        grey = new Mat(width,height,CvType.CV_8SC1);
        cannyedge = new Mat(width,height,CvType.CV_8SC1);

    }

    @Override
    public void onCameraViewStopped() {
        mat.release();

    }



    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mat=inputFrame.rgba();
        Mat mRgba = mat.t();
        Core.flip(mat.t(),mRgba,1);

        Imgproc.resize(mRgba,mRgba,mat.size());
        Imgproc.cvtColor(mRgba,grey,Imgproc.COLOR_RGB2GRAY);

        Imgproc.medianBlur(grey,grey,5);



        Mat circles = new Mat();
        Imgproc.HoughCircles(grey, circles, Imgproc.HOUGH_GRADIENT, 1.0,
                (double)grey.rows()/16, // change this value to detect circles with different distances to each other
                100.0, 30.0, 10, 150); // change the last two parameters
        // (min_radius & max_radius) to detect larger circles
        for (int x = 0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            // circle center
            Imgproc.circle(mat, center, 1, new Scalar(0,100,100), 3, 8, 0 );
            // circle outline
            int radius = (int) Math.round(c[2]);
            Imgproc.circle(mat, center, radius, new Scalar(255,0,255), 3, 8, 0 );
        }




        return mat;
    }






}