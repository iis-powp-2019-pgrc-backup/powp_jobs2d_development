package edu.kis.powp.jobs2d.movment;

import java.awt.*;

public class Rotate implements PointMovment {

    private RotateManager rotateManager;

    public Rotate(RotateManager mgr)
    {
        rotateManager = mgr;
    }

    @Override
    public Point transform(Point point) {
        double rotation = Math.toRadians(rotateManager.getRotation());
        int shiftX = parseDoubleToInt((point.x) * Math.cos(rotation) - (point.y) * Math.sin(rotation));
        int shiftY = parseDoubleToInt((point.x) * Math.sin(rotation) + (point.y) * Math.cos(rotation));
        point.x = shiftX;
        point.y = shiftY;
        return point;
    }
    private int parseDoubleToInt(double number){
        return (int)number;
    }
}
