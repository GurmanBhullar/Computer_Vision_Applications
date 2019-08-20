package com.example.cvpr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button circle;
    Button Corner;
    Button canny;
    Button Hisequal;
    Button rgb;
    Button sobel;
    Button preview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        circle = findViewById(R.id.CircleBtn);
        Corner = findViewById(R.id.cornerBtn);
        canny = findViewById(R.id.cannyBtn);
        rgb = findViewById(R.id.rgbTograyBtn);
        Hisequal = findViewById(R.id.HistogramEqlBtn);
        sobel = findViewById(R.id.SobelBtn);
        preview = findViewById(R.id.PreviewBtn);

        canny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Canny.class);
                startActivity(intent1);
            }
        });

        rgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,RGBtoGray.class);
                startActivity(intent1);
            }
        });

        Hisequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,HisEqualizer.class);
                startActivity(intent1);
            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Preview.class);
                startActivity(intent1);
            }
        });

        sobel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Sobel_edge.class);
                startActivity(intent1);
            }
        });


        Corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this,Line_transform.class);
                startActivity(intent1);

            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Circle.class);
                startActivity(intent);
            }
        });


    }
}
