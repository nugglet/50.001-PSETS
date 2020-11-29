package com.isp.midterm2018;

public class Circle {

    private double x;
    private double y;
    private double radius;

    public Circle(){
        this.radius = 1;
        this.x = 0;
        this.y = 0;
    }

    public Circle(double x, double y, double radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        double area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }

    public double getPerimeter(){
        double perim = 2 * Math.PI * this.radius;
        return perim;
    }

    public boolean contains(double px, double py){
        double xRight = this.x + this.radius;
        double xLeft = this.x - this.radius;
        double yUpper = this.y + this.radius;
        double yLower = this.y - this.radius;

        if (px >= xLeft && px <= xRight && py >= yLower && py <= yUpper){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean contains(Circle c){

        double cUp = c.getY() + c.radius;
        double cDown = c.getY() - c.radius;
        double cLeft = c.getX() - c.radius;
        double cRight = c.getX() + c.radius;

        double xr = this.x + this.radius;
        double xl = this.x - this.radius;
        double yu = this.y + this.radius;
        double yd = this.y - this.radius;

        if (cUp <= yu && cDown >= yd && cLeft >= xl && cRight <= xr){
            return true;
        } else {
            return false;
        }
    }

    public boolean overlaps(Circle c){

        double centreDist = Math.sqrt(Math.pow( (this.x - c.getX()) , 2)
                + Math.pow((this.y - c.getY()), 2));
        if (this.contains(c)){
            return false;
        } else if (centreDist > this.radius + c.getRadius()){
            return false;
        } else {
            return true;
        }
    }
}

class TestCircle {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c.getArea());
        System.out.println(c.getPerimeter());
        System.out.println(c.contains(1,0));
        System.out.println(c.contains( new Circle(0.5, 0, 0.3)));
        System.out.println(c.overlaps(new Circle(0,2,0.5)));
        Circle c2 = new Circle(1,1,1);
        System.out.println(c.getArea());
    }
}