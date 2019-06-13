package edu.kis.powp.jobs2d.command.gui.transformations;

import java.awt.*;

public class ShiftPointTransformer implements PointTransformer {

    private PointShiftManager shiftManager;

    public ShiftPointTransformer(PointShiftManager mgr)
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
