package com.isp.pset1a;

import java.util.Arrays;

public class pset1Alt {
    //only viable for 32 unique characters since this uses 1 bit to in an in to represent a char
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // NOTE: Are you sure this isn't 26?
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

   public static boolean isPermutations(String sIn1, String sIn2){
       int len1 = sIn1.length();
       int len2 = sIn2.length();

       if (len1 != len2){
           return false;
       }else{
           char[] s1 = sIn1.toCharArray();
           char[] s2 = sIn2.toCharArray();
           Arrays.sort(s1);
           Arrays.sort(s2);

           for (int k=0; k < len1; k++){
               if (s1[k] != s2[k]){
                   return false;
               }
           }
       }
       return true;
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
