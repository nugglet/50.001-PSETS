package com.isp.midterm2018.Starter;

import com.isp.midterm2018.TemperatureAlert;

public class Fish  implements Observer {
    private String id;
    private TemperatureAlert alert;

    public Fish(String id, TemperatureAlert alert) {
        this.id = id;
        this.alert = alert;
        alert.register(this);
    }

    @Override
    public void update(int t) {
        String ans = String.format("Fish %s receives temperature alert: %d",
                this.id, t);
        System.out.println(ans);

    }
}

