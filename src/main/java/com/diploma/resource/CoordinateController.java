package com.diploma.resource;

import com.diploma.entity.Coordinate;
import com.diploma.service.CoordinateService;
import com.diploma.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoordinateController {

    @Autowired
    private CoordinateService coordinateService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public List<Coordinate> result(@RequestParam double startX, @RequestParam double startY, @RequestParam double endX, @RequestParam double endY, @RequestParam double h) {
        ArrayList<Coordinate> list = new ArrayList<>();
        list.add(new Coordinate(-25, -0.01));
        list.add(new Coordinate(-24, 0.004));
        list.add(new Coordinate(-23, 0.002));
        list.add(new Coordinate(-22, 0.02));
        list.add(new Coordinate(-21, 0));
        list.add(new Coordinate(-20, 0.005));
        list.add(new Coordinate(-19, 0.0003));
        list.add(new Coordinate(-18, 0));
        list.add(new Coordinate(-17, -0.01));
        list.add(new Coordinate(-16, -0.023));
        list.add(new Coordinate(-15, -0.005));
        list.add(new Coordinate(-14, 0.00016));
        list.add(new Coordinate(-13, 0));
        list.add(new Coordinate(-12, -0.3));
        list.add(new Coordinate(-11, -5.0071));
        list.add(new Coordinate(-10, -10.045));
        list.add(new Coordinate(-9, 00.1));
        list.add(new Coordinate(-8, 00.1));
        list.add(new Coordinate(-7, 00.1));
        list.add(new Coordinate(-6, 00.1));
        list.add(new Coordinate(-5, 00.1));
        list.add(new Coordinate(-4, 00.1));
        list.add(new Coordinate(-3, 00.1));
        list.add(new Coordinate(-2, 00.1));
        list.add(new Coordinate(-1, 00.1));
        list.add(new Coordinate(0, 00.1));
        list.add(new Coordinate(1, 00.1));
        list.add(new Coordinate(2, 00.1));
        list.add(new Coordinate(3, 00.1));
        list.add(new Coordinate(4, 00.1));
        list.add(new Coordinate(5, 00.1));
        list.add(new Coordinate(6, 00.1));
        list.add(new Coordinate(7, 00.1));
        list.add(new Coordinate(8, 00.1));
        list.add(new Coordinate(9, 00.1));
        list.add(new Coordinate(10, 00.1));
        list.add(new Coordinate(11, 00.1));
        list.add(new Coordinate(12, 00.1));
        list.add(new Coordinate(13, 00.1));
        list.add(new Coordinate(14, 00.1));
        list.add(new Coordinate(15, -1.7078));
        list.add(new Coordinate(16, -0.845));
        list.add(new Coordinate(17, -0.456));
        list.add(new Coordinate(18, -0.234));
        list.add(new Coordinate(19, -1.0002));
        list.add(new Coordinate(20, -1.235));
        list.add(new Coordinate(21, -1.493));
        list.add(new Coordinate(22, -0.812));
        list.add(new Coordinate(23, 0.378));
        list.add(new Coordinate(24, 0.861));

//        return  coordinateService.generateResult(startX, startY, endX, endY, h);
        return list;
    }

    @RequestMapping(value = "/sendResult", method = RequestMethod.GET)
    public void sendResultToEmail(@RequestParam String email, @RequestParam String result) {
        emailService.sendEmail(email, result);
    }
}
