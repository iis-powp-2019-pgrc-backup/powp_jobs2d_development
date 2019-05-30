package edu.kis.powp.jobs2d.command.gui.transformations;

public class TransformManager
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

    public int getTransformX() {
        return transformX;
    }

    public int getTransformY() {
        return transformY;
    }

    public int getRotation() {
        return rotation;
    }

    public void UpdateTransform(int x, int y, int r)
    {
        transformX = x;
        transformY = y;
        rotation = r;
    }
}
