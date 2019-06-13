package edu.kis.powp.jobs2d.command.gui.transformations;

import java.awt.*;

public class RotatePointTransformer implements PointTransformer {

    private RotationManager rotationManager;

    public RotatePointTransformer(RotationManager mgr)
    {
        rotationManager = mgr;
    }

    @Override
    public Point transform(Point point) {
        double rotation = Math.toRadians(rotationManager.getRotation());
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
