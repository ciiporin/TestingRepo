/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Peter
 */  
    import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
    
public class JavaCVTest {
    
  //
public static void main(String[] args) {
// TODO Auto-generated method stub

IplImage img = cvLoadImage("Copy of Bluehills.jpg"); cvShowImage("Copy of Bluehills.jpg",img); cvSmooth(img, img, CV_GAUSSIAN, 13); cvShowImage("Copy of Bluehills.jpg",img); cvWaitKey(); cvReleaseImage(img);
}
}

