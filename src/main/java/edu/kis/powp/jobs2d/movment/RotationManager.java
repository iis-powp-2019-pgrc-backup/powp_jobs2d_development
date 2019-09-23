package edu.kis.powp.jobs2d.movment;


public class RotationManager implements RotateManager, PointShiftManager
{

    private static int transformX;
    private static int transformY;
    private static int rotation;

    public RotationManager() {
        transformX = 0;
        transformY = 0;
        rotation = 0;
    }

    public int getShiftX() { return transformX; }
    public int getShiftY()  {
        return transformY;
    }
    public int getRotation() { return rotation; }

}
