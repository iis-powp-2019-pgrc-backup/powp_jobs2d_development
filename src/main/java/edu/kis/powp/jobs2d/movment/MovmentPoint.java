package edu.kis.powp.jobs2d.movment;

import java.awt.*;

public class MovmentPoint implements PointMovment {

    private PointShiftManager shiftManager;

    public MovmentPoint(PointShiftManager mgr)
    {
        shiftManager = mgr;
    }


    @Override
    public Point transform(Point point) {
        int tempX = shiftManager.getShiftX();
        int tempY = shiftManager.getShiftY();
        point.x += tempX;
        point.y += tempY;
        return point;

    }
}
