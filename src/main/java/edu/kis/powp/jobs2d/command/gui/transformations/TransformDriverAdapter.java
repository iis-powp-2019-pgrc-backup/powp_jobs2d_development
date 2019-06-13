package edu.kis.powp.jobs2d.command.gui.transformations;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransformDriverAdapter implements Job2dDriver {

    private Job2dDriver driver;
    private List<PointTransformer> transformerList;
    private String name;


    public TransformDriverAdapter(Job2dDriver driver, String name) {
        super();
        this.driver = driver;
        this.name = name;
        transformerList = new ArrayList<>();
    }

    @Override
    public void setPosition(int x, int y) { ;
        Point p = new Point(x, y);
        for(PointTransformer pointTransformer : transformerList){
            pointTransformer.transform(p);
        }
        driver.setPosition(p.x,p.y);
    }

    @Override
    public void operateTo(int x, int y) {
        Point p = new Point(x, y);
        for(PointTransformer pointTransformer : transformerList){
            pointTransformer.transform(p);
        }
        driver.operateTo(p.x,p.y);
    }
    public void addTransformation(PointTransformer pointTransformer){
        transformerList.add(pointTransformer);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }

}
