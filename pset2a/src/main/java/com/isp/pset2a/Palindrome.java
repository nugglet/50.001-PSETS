package com.isp.pset2a;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new char[]{'a', 'b', 'b', 'a'}));
        System.out.println(isPalindrome(new char[]{'a', 'd', 'b', 'c', 'b', 'a'}));
        System.out.println(isPalindrome(new char[]{'Z', 'Z', 'a', 'Z', 'Z'}));
        System.out.println(isPalindrome(new char[]{'1', '2', '3', '4', '2', '1'}));
    }

    public static boolean isPalindrome(char[] S) {
        if (S[0] != S[S.length - 1]) {
            return false;
        }

        char[] temp = new char[S.length - 2];
        for (int j = 0; j < temp.length; j++) {
            temp[j] = S[j + 1];
        }

        if (temp.length > 1) {
            return isPalindrome(temp);
        }
        return true;
    }
}