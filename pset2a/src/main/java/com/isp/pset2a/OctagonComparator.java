package com.isp.pset2a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class OctagonComparator implements Comparator<Octagon> {

    public int compare(Octagon o1, Octagon o2){
        if (o1.getSide() < o2.getSide()) return -1;
        else if (o1.getSide() == o2.getSide()) return 0;
        else return 1;

    }

    public static void main(String[] args) {
        ArrayList<Octagon> l = new ArrayList<Octagon>();
        l.add(new Octagon(2));
        l.add(new Octagon(3));
        l.add(new Octagon(1));
        Collections.sort(l, new OctagonComparator());
        for (Octagon o:l)
            System.out.println(o.getSide());
    }

}
