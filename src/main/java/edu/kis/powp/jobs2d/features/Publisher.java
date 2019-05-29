package edu.kis.powp.jobs2d.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Publisher {
    private String publisherName;
    public static Map<String, Publisher> publishers = new HashMap<>();

    boolean isNotyfying = false;
    ArrayList<Subscriber> subscribers = new ArrayList<>();

    public Publisher(String publisherName){
        this.publisherName = publisherName;

        publishers.put(publisherName, this);
    }

    public static Publisher getPublisher(String publisherName){
        return publishers.get(publisherName);
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
        ArrayList<Subscriber> tempSubs = new ArrayList<>();
        for(Subscriber s : subscribers){
            tempSubs.add(s);
        }

        return tempSubs;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
}
