package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

public class DriverDecoratorApplicator {

    private Class decoratorClass;
    private boolean stateToDecorate;
    private Job2dDriver beforeDecoration;

    public DriverDecoratorApplicator(Class decoratorClass, boolean stateToDecorate) {
        this.decoratorClass = decoratorClass;
        this.stateToDecorate = stateToDecorate;
    }

    public Class getDecoratorClass() {
        return decoratorClass;
    }

    public void changeStateToDecorate(){
        stateToDecorate = !stateToDecorate;
    }

    public boolean isStateToDecorate() {
        return stateToDecorate;
    }

    public Job2dDriver applicateDecoration(Job2dDriver job2dDriver){
        if(stateToDecorate) return decorate(job2dDriver);
        else return undoDecorate(job2dDriver);
    }

    private Job2dDriver decorate(Job2dDriver job2dDriver){
        beforeDecoration = job2dDriver;

        try {
            job2dDriver = (Job2dDriver)  decoratorClass.getConstructor(Job2dDriver.class).newInstance(job2dDriver);
        } catch (Exception e){
            return job2dDriver;
        }

        return job2dDriver;
    }

    private Job2dDriver undoDecorate(Job2dDriver job2dDriver){
        if(beforeDecoration != null) return beforeDecoration;
        else return job2dDriver;
    }

}
