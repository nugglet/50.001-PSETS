package com.isp.midterm2018;

import com.isp.midterm2018.Starter.Fish;
import com.isp.midterm2018.Starter.Observer;
import com.isp.midterm2018.Starter.Student;
import com.isp.midterm2018.Starter.Subject;

import java.util.ArrayList;

public class TemperatureAlert implements Subject {

    private int temperature = 0;
    private ArrayList<Observer> registry = new ArrayList<>();

    public TemperatureAlert() {

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        if (this.temperature > 35 || this.temperature < 10) {
            for (Observer o : registry) {
                o.update(this.temperature);
            }
        }
    }

    @Override
    public void register(Observer o) {
        registry.add(o);
    }

    @Override
    public void unregister(Observer o) {
        registry.remove(o);
    }
}

class TestTemperatureAlert {
    public static void main(String[] args) {
        TemperatureAlert westCoast = new TemperatureAlert();
        Student s1 = new Student("s1", westCoast);
        Student s2 = new Student("s2", westCoast);
        westCoast.setTemperature(40);
        westCoast.setTemperature(25);
        westCoast.setTemperature(5);
        westCoast.unregister(s1);
        Student s3 = new Student("s3", westCoast);
        Fish f1 = new Fish("f1", westCoast);
        westCoast.setTemperature(2);
    }
}
