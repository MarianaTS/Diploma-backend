package com.diploma.service;

import com.diploma.entity.Coordinate;
import java.util.List;

public interface CoordinateService {

    List<Coordinate> generateResult (double startX, double startY, double endX, double endY, double h );

}
