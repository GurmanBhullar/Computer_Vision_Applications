# Computer_Vision_Applications
A Camera preview application describing the use of various parameters of an Image and using then to make:
* filters 
* detecting edges  
* Detecting circles  
* Histogram Equalization
* RGB to GrayScale using Computer Vision methods.

# Objective
To help the students understand the difference between various openCV features using a real time processing application using the smartphone camera to analyse the different filters available.

# Technologies Used:
* Kotlin
* OpenCV Library

# Brief explaination about algotithms
* Circles algorithm: HoughCircles function in OpenCV to detect circles in images. Unlike detecting squares or rectangles in images, detecting circles is substantially harder since we cannot reply on approximating the number of points in a contour. To help us detect circles in images, OpenCV has supplied the cv2. HoughCircles function

* Corner detection Algortihm: Harris Corner detection algorithm was developed to identify the internal corners of an image. The corners of an image are basically identified as the regions in which there are variations in large intensity of the gradient in all possible dimensions and directions. Corners extracted can be a part of the image features, which can be matched with features of other images, and can be used to extract accurate information. Harris Corner Detection is a method to extract the corners from the input image and to extract features from the input image.

* Canny Edge detection: The Canny edge detector is an edge detection operator that uses a multi-stage algorithm to detect a wide range of edges in images.Canny edge detection is a technique to extract useful structural information from different vision objects and dramatically reduce the amount of data to be processed. It has been widely applied in various computer vision systems. Canny has found that the requirements for the application of edge detection on diverse vision systems are relatively similar. Thus, an edge detection solution to address these requirements can be implemented in a wide range of situations. 
* RGB to GreyScale: a grayscale image is one in which the value of each pixel is a single sample representing only an amount of light; that is, it carries only intensity information. Grayscale images, a kind of black-and-white or gray monochrome, are composed exclusively of shades of gray. The contrast ranges from black at the weakest intensity to white at the strongest.

* Histogram Equilizer:  Histogram equalization is a method in image processing of contrast adjustment using the image's histogram.This method usually increases the global contrast of many images, especially when the image is represented by a narrow range of intensity values. Through this adjustment, the intensities can be better distributed on the histogram utilizing the full range of intensities evenly. This allows for areas of lower local contrast to gain a higher contrast. Histogram equalization accomplishes this by effectively spreading out the highly populated intensity values which use to degrade image contrast.

* Sobel Edge detection: The Sobel operator performs a 2-D spatial gradient measurement on an image and so emphasizes regions of high spatial frequency that correspond to edges. Typically it is used to find the approximate absolute gradient magnitude at each point in an input grayscale image.In theory at least, the operator consists of a pair of 3×3 convolution kernels. One kernel is simply the other rotated by 90°. This is very similar to the Roberts Cross operator. These kernels are designed to respond maximally to edges running vertically and horizontally relative to the pixel grid, one kernel for each of the two perpendicular orientations. The kernels can be applied separately to the input image, to produce separate measurements of the gradient component in each orientation (call these Gx and Gy). These can then be combined together to find the absolute magnitude of the gradient at each point and the orientation of that gradient

# Application screenshots
![image](https://user-images.githubusercontent.com/40751910/119790407-87d1c700-bef1-11eb-832e-30ba5c7d5ee4.png)
![image](https://user-images.githubusercontent.com/40751910/119790428-8d2f1180-bef1-11eb-8323-e7753555129a.png)
![image](https://user-images.githubusercontent.com/40751910/119790372-80122280-bef1-11eb-927d-322908e5b6ab.png)
![image](https://user-images.githubusercontent.com/40751910/119790459-94561f80-bef1-11eb-97c4-e2f309edc64e.png)
![image](https://user-images.githubusercontent.com/40751910/119790487-9a4c0080-bef1-11eb-91a5-016422b087b1.png)
![image](https://user-images.githubusercontent.com/40751910/119790513-9f10b480-bef1-11eb-93fa-9e2ed7b5d1e7.png)

