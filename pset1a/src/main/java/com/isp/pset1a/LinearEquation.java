package com.isp.pset1a;

public class LinearEquation {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getD() {
        return this.d;
    }

    public double getE() {
        return this.e;
    }

    public double getF() {
        return this.f;
    }

    public boolean isSolvable(){
        if ((this.a*this.d) - (this.b*this.c) == 0){
            return false;
        }else{
            return true;
        }
    }

    public double getX(){
        double xx = (this.e - (this.b*this.f/this.d))/(this.a - (this.b*this.c/this.d));
        return xx;
    }

    public double getY(){
        double xx = getX();
        double yy = (this.f - (this.c * xx))/this.d;
        return yy;
    }
}
