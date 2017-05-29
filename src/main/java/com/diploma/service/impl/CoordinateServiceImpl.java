package com.diploma.service.impl;

import com.diploma.entity.Coordinate;
import com.diploma.service.CoordinateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CoordinateServiceImpl  implements CoordinateService{

    @Override
    public List<Coordinate> generateResult(double startX, double startY, double endX, double endY, double h) {
        Random r = new Random();
        double x = startX;
        List<Coordinate> result = new ArrayList<>();
        while (x < endY) {
            result.add(Coordinate.builder()
            .x(x)
            .y(r.nextDouble())
            .build());

            x+=h;
        }
        return result;
    }
}
