package com.isp.pset1a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pset1 {
    public static boolean isAllCharacterUnique(String sIn) {
        //convert string to char array
        char[] letters = sIn.toCharArray();
        for (int i = 0; i < letters.length; i++){
            for (int j = i + 1; j < letters.length; j++){
                // check letters after
                if (letters[j] == letters[i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        //convert to char array
        char[] s1 = sIn1.toCharArray();
        char[] s2 = sIn2.toCharArray();
        boolean inS2 = false;
        if (s1.length != s2.length){
            return false;
        }else {
            int count = s1.length;
            for (char a: s1){
                for (char b: s2){
                    count --;
                    if (a == b){
                        inS2 = true;
                        break;
                    }else{
                        inS2 = false;
                    }
                    if (count == 0 && inS2 == false){
                        return false;
                    }
                }
            }
        }
        return inS2;
    }
    public static void main(String[] args) {
        double start = System.nanoTime();
        System.out.println(Pset1.isAllCharacterUnique("abcdefghijklmnopqrstuvABC"));
        double end = System.nanoTime();
        System.out.println(end);
        //System.out.println(Pset1.isAllCharacterUnique("abcdefgghijklmnopqrstuvABC"));
        //System.out.println(Pset1.isPermutation("@ab", "a@b"));
        //System.out.println(Pset1.isPermutation("abcd", "bcdA"));

    }


}

