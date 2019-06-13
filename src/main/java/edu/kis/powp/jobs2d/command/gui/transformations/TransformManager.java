package edu.kis.powp.jobs2d.command.gui.transformations;

public class TransformManager implements RotationManager, PointShiftManager
{
    private int transformX;
    private int transformY;
    private int rotation;

    public TransformManager()
    {
        transformX = 0;
        transformY = 0;
        rotation = 0;
    }

    public int getShiftX() { return transformX; }
    public int getShiftY()  {
        return transformY;
    }
    public void setShiftX(int x) { transformX = x; }
    public void setShiftY(int y) { transformY = y; }

    public int getRotation() { return rotation; }
    public void setRotation(int rotation) { this.rotation = rotation; }
}
