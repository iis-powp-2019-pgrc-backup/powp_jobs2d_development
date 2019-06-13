package edu.kis.powp.jobs2d.command.gui.transformations;

import edu.kis.powp.jobs2d.features.TransformFeature;

import java.awt.*;

public class ShiftPointTransformer implements PointTransformer {
    @Override
    public Point transform(Point point) {
        int tempX = TransformFeature.getTransformManager().getTransformX();
        int tempY = TransformFeature.getTransformManager().getTransformY();
        point.x += tempX;
        point.y += tempY;
        return point;
    }
}
