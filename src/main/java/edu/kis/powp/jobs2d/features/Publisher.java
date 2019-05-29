package edu.kis.powp.jobs2d.features;

import java.util.ArrayList;

public class Publisher {
    boolean isNotyfying = false;
    ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();

    public Publisher(){

    }

    public void notifyObservers(){
        for (Subscriber s : subscribers) {
            s.update();
        }
    }

    public void clearObservers(){
        subscribers.clear();
    }

    public ArrayList<Subscriber> getSubscribers(){
        return subscribers;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
}
