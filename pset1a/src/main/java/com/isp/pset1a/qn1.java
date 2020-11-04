package com.isp.pset1a;

public class qn1 {

    public static void main(String [] args) {
        String result = fibonacci(5);
        System.out.println(result);
    }

    public static String fibonacci(int n) {
        int x1 = 0;
        int x2 = 1;
        int x3 = 0;
        String ans = new String();
        String space = new String(",");
        if (n < 0) {
            ans += Integer.toString(0);
            return ans;
        } else if (n == 1) {
            ans += Integer.toString(x1);
            return ans;
        }else if (n == 2) {
                ans = new String(Integer.toString(x1) + "," + Integer.toString(x2));
                return ans;
        }else{
            ans = new String(Integer.toString(x1) + "," + Integer.toString(x2));
            for (int i = 3; i <= n; i++) {
                x3 = x1 + x2;
                ans += space;
                ans += Integer.toString(x3);
                x1 = x2;
                x2 = x3;
            }
        }
        return ans;
    }
}