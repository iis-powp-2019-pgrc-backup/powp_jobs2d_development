package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.features.Publisher;

public class Subscriber implements edu.kis.powp.jobs2d.features.Subscriber {

    public Subscriber(){
    }

    @Override
    public void update(String info) {
        System.out.println(info);
    }
}
