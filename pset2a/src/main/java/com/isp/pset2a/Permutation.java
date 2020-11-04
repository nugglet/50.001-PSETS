package com.isp.pset2a;

import java.util.ArrayList;

public class Permutation {
    private String in;
    private ArrayList<String> a = new ArrayList<>();
    // additional attribute if needed
    private int l;

    Permutation(final String str){
        in = str;
        // additional initialization if needed
        l = 0;
    }

    public void permute(){
        // produce the permuted sequences of 'in' and store in 'a', recursively
        for (int i = l; i <= in.length() - 1; i++) {
            in = swap(in,l,i);
            l++;
            permute();
            l--;
            in = swap(in,l,i);
            if (!a.contains(in)) {
                a.add(in);
            }
        }
    }

    public static String swap(String in, int i, int j) {
        char[] charArray = in.toCharArray();
        char a = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = a;
        return String.valueOf(charArray);
    }

    public ArrayList<String> getA(){
        return a;
    }
}

class TestPermutation {
    public static void main(String[] args) {
        ArrayList<String> v;

        Permutation p = new Permutation("hat");
        p.permute();
        v = p.getA();
        System.out.println(v);

    }
}