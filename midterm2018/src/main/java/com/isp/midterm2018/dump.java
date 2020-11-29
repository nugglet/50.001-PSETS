package com.isp.midterm2018;

public class dump {

    public static void main(String[] args){
        int count = 0;
        try{
            double a = quotientDouble(5, 0);
            count++;
        }catch (ArithmeticException e){
            e.printStackTrace();
            count++;
        }
        count++;
        System.out.println(count);
    }

    public static int quotientInt(int a, int b){
        return a / b;
    }

    public static double quotientDouble(double a, double b){
        return a/b;
    }
}
