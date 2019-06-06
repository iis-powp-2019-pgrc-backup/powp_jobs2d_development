package edu.kis.powp.jobs2d.customizableLine;

import edu.kis.legacy.drawer.shape.line.AbstractLine;

import java.awt.*;

public class CustomizableLine extends AbstractLine {

    private static CustomizableLine customizableLine;

    private CustomizableLine() {
        super();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    public void setDotted(boolean isDotted) {
        this.dotted = isDotted;
    }

    public static CustomizableLine getInstance(){
        if(customizableLine == null){
            customizableLine = new CustomizableLine();
        }
        return customizableLine;
    }
}
