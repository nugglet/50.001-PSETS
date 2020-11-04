package com.isp.pset1a;

import java.util.ArrayList;
import java.util.List;

public class qn3 {

    public static void main(String[] args){
        List<Integer> input = new ArrayList<Integer>();
        for (int i=0; i<5; i++){
            input.add(i, i+1);
        }
        System.out.println(input);

        int a = Act2ForEach(input);
        System.out.println(a);
    }

    public static int Act2ForEach(List<Integer> integers) {
        int sum = 0;
        for (int x : integers){
            sum += x;
        }

        return sum;

    }
}
