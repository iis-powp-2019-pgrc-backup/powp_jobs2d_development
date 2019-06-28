package edu.kis.powp.jobs2d.features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Publisher {
    private static Map<String, Publisher> publishers = new HashMap<>();

    private ArrayList<Subscriber> subscribers = new ArrayList<>();

    public Publisher(String publisherName){

        publishers.put(publisherName, this);
    }

    public static Publisher getPublisher(String publisherName){
        return publishers.get(publisherName);
    }

    public void notifyObservers(String info){
        for (Subscriber s : subscribers) {
            s.update(info);
        }
    }

    public void clearObservers(){
        subscribers.clear();
    }

    public ArrayList<Subscriber> getSubscribers(){
        ArrayList<Subscriber> tempSubs = new ArrayList<>(subscribers);

        return tempSubs;
    }

    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
}
