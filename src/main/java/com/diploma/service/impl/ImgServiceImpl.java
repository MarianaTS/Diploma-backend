package com.diploma.service.impl;

import com.diploma.service.ImgService;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.opencv.imgcodecs.Imgcodecs.*;

public class ImgServiceImpl implements ImgService {
    @Override
    public BufferedImage gausBlur(BufferedImage bufferedImage) throws IOException {
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        Mat source = imread("digital_image_processing.jpg",
                CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows(),source.cols(),source.type());
        Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
        Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
        imwrite("sharp.jpg", destination);
        return null;
    }
}
