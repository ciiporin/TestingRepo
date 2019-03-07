/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacv;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
/**
 *
 * @author matthewp
 */
public class JavaCV {


//
public static void main(String[] args) {
// TODO Auto-generated method stub

IplImage img = cvLoadImage("Jellyfish.jpg"); cvShowImage("Jellyfish",img); cvSmooth(img, img, CV_GAUSSIAN, 13); cvShowImage("Blur-Image",img); cvWaitKey(); cvReleaseImage(img); 
}
}

  

