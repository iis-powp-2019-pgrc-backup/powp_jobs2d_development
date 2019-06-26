package edu.kis.powp.jobs2d.movment;


import java.util.logging.Logger;

public class MovmentManager implements RotateManager, PointShiftManager
{
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static int transformX;
    private static int transformY;
    private static int rotation;

    public MovmentManager() {
        transformX = 0;
        transformY = 0;
        rotation = 0;
    }

    public static void setX() {
        transformX +=20;
        logger.info("x:" + transformX);

    }


    public static void setY() {
        transformY+=20;
        logger.info("y: " + transformY);
    }

    public static void setXX() {
        transformX-=20;
        logger.info("x: " + transformX);
    }


    public static void setYY() {
        transformY-=20;
        logger.info("y: " + transformY);
    }

    public static void mouseevent(int Xaxis , int Yaxis, int width, int height) {
        transformY=Yaxis-height/2;
        transformX=Xaxis-width/2;
        logger.info("x: " + transformX + " y: " + transformY);
    }

    public static void reset() {
        transformY=0;
        transformX=0;
        logger.info("x: " + transformX + " y: " + transformY);
    }
    public static void RotationUp() {
        rotation+=10;
        logger.info("Rotation:" + rotation);

    }

    public static void RotationDown() {
        rotation-=10;
        logger.info("Rotation:" + rotation);

    }
    public static void RotationReset() {
        rotation=0;
        logger.info("Rotation:" + rotation);

    }
    public int getShiftX() { return transformX; }
    public int getShiftY()  {
        return transformY;
    }
    public int getRotation() { return rotation; }
}
