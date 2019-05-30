package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.gui.transformations.TransformManager;

public class TransformFeature
{
    private static TransformManager transformManager;

    public static void setupTransformManager()
    {
        transformManager = new TransformManager();
    }

    public static TransformManager getTransformManager() { return transformManager; }
}
