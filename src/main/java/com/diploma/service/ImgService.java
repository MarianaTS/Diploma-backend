package com.diploma.service;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ImgService {
    BufferedImage gausBlur(BufferedImage bufferedImage) throws IOException;
}
