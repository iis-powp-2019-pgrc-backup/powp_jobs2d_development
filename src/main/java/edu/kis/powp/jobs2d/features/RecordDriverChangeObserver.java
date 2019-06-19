package edu.kis.powp.jobs2d.features;

import edu.kis.powp.observer.Subscriber;

public class RecordDriverChangeObserver implements Subscriber {

    @Override
    public void update() {
        RecorderFeature.onDriverChanged();
    }
}
