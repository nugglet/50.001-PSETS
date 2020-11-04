package com.isp.pset1a;

import java.util.ArrayList;
import java.util.List;

public class qn2 {

    public static void main(String[] args){
        List<Integer> input = new ArrayList<Integer>();
        for (int i=0; i<5; i++){
            input.add(i, i+1);
        }
        System.out.println(input);

        int a = Act2Iterator(input);
        System.out.println(a);
    }

    public static int Act2Iterator(List<Integer> integers) {
        int sum = 0;
        for (int i=0; i< integers.size(); i++){
            sum += integers.get(i);
        }

        return sum;
    }

}
