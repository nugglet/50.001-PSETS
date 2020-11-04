package com.isp.pset1a;

public class qn5 {

    public static int isPrime(int num){
        int i = 2;
        while (i < num){
            int remainder = num % i;
            i++;
            if (remainder == 0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int[] test = {4, 7, 14, 23, 99};
        for (int num: test) {
            int check = isPrime(num);
            System.out.print(check);
        }

        }
    }

