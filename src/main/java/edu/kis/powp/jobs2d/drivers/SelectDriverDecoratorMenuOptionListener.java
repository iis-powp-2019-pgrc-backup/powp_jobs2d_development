package edu.kis.powp.jobs2d.drivers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class SelectDriverDecoratorMenuOptionListener  implements ActionListener {

    private Class toDecorate;

    public SelectDriverDecoratorMenuOptionListener(Class toDecorate) {
        this.toDecorate = toDecorate;
    }

    @Override public void actionPerformed(ActionEvent e) {
        HashSet<Class> decoratorSet = DriverDecoratorFeature.getDecoratorMap();

        if(decoratorSet.contains(toDecorate)) decoratorSet.remove(toDecorate);
        else decoratorSet.add(toDecorate);
    }
}
