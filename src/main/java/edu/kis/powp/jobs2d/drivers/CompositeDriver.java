package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.LinkedList;
import java.util.List;

public class CompositeDriver implements Job2dDriver {

    List<Job2dDriver> driverList;

    public  CompositeDriver(){
        driverList=new LinkedList<>();
    }

    public CompositeDriver(List driverList) {
        this.driverList=driverList;
    }

    public void addDriver(Job2dDriver job2dDriver){
        driverList.add(job2dDriver);
    }

    @Override
    public void setPosition(int i, int y) {
        for(Job2dDriver job2dDriver : this.driverList){
            job2dDriver.setPosition(i, y);
        }
    }

    @Override
    public void operateTo(int i, int y) {
        for(Job2dDriver job2dDriver : this.driverList){
            job2dDriver.operateTo(i, y);
        }
    }
}
