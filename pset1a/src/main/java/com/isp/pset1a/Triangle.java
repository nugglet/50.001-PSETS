package com.isp.pset1a;

import java.lang.Math;

public class Triangle{

    private double side1;
    private double side2;
    private double side3;

    public Triangle(){
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double a, double b, double c){
        this.side1 = a;
        this.side2 = b;
        this.side3 = c;
    }

    public double getArea(){
        double s = 0.5*(getPerimeter());
        double area = Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
        return area;
    }

    public double getPerimeter(){
        return this.side1 + this.side2 + this.side3;

    }

    public String toString(){
        String out = "Triangle: side1 = " + this.side1 + " side2 = " +
                this.side2 + " side3 = " + this.side3;
        return out;
    }

}
