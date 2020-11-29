package com.isp.midterm2018.Starter;

//starting code
public interface Subject {

    void notifyObservers();
    void register(Observer o);
    void unregister(Observer o);

}
