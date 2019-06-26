package edu.kis.powp.jobs2d.movment;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveDriverAdapter implements Job2dDriver {

    private Job2dDriver driver;
    private List<PointMovment> transformerList;
    private String name;


    public MoveDriverAdapter(Job2dDriver driver, String name) {
        super();
        this.driver = driver;
        this.name = name;
        transformerList = new ArrayList<>();
    }

    @Override
    public void setPosition(int x, int y) { ;
        Point p = new Point(x, y);
        for(PointMovment pointMovment : transformerList){
            pointMovment.transform(p);
        }
        driver.setPosition(p.x,p.y);
    }

    @Override
    public void operateTo(int x, int y) {
        Point p = new Point(x, y);
        for(PointMovment pointMovment : transformerList){
            pointMovment.transform(p);
        }
        driver.operateTo(p.x,p.y);
    }
    public void addTransformation(PointMovment pointMovment){
        transformerList.add(pointMovment);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }
}
