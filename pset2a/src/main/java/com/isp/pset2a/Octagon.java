package com.isp.pset2a;

import java.util.ArrayList;
import java.util.Collections;

public class Octagon implements Comparable<Octagon>{

    private double side;

    public Octagon(double side){
        this.side = side;
    }

    public double getSide(){
        return side;
    }

    public int compareTo(Octagon oct){
        if (side < oct.getSide()) {
            return -1;
        }else if (side == oct.getSide()){
           return 0;
        }
        else {
            return 1;
        }
    }


    public static void main(String[] args) {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l);
        for (Octagon o:l)
            System.out.println(o.getSide());
    }

}

