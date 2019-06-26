package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.movment.MovmentManager;


public class MoveFeature {
    private static MovmentManager movmentManager;

    public static void setupTransformManager()
    {
        movmentManager = new MovmentManager();
    }
    public static MovmentManager getMovmentManager() { return movmentManager; }

}