package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapterUseControl;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DriverDecoratorFeature {

    private static HashSet<Class> decoratorMap = new HashSet<Class>();

    public static HashSet<Class> getDecoratorMap() {
        return decoratorMap;
    }

}
