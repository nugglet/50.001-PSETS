package com.isp.pset1a;

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle2D(){
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //getters and setters

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setX(double xn){
        this.x = xn;
    }

    public void setY(double yn){
        this.y = yn;
    }

    public void setWidth(double newWidth){
        this.width = newWidth;
    }

    public void setHeight(double newHeight){
        this.height = newHeight;
    }

    public double getArea(){
        double area = this.height * this.width;
        return area;
    }

    public double getPerimeter(){
        double perimeter = (2*this.width) + (2*this.height);
        return perimeter;
    }

    public boolean contains(double a, double b){
        double upperBound = this.y + (this.height/2);
        double lowerBound = this.y - (this.height/2);
        double rightBound = this.x + (this.width/2);
        double leftBound = this.x - (this.width/2);
        if( a<rightBound && a>leftBound && b<upperBound && b>lowerBound){
            return true;
        }else{
            return false;
        }
    }

    public boolean contains(MyRectangle2D r){
        boolean topRight = contains(r.x + (r.width/2) , r.y + (r.height/2) );
        boolean topLeft = contains(r.x - (r.width/2), r.y +(r.height/2));
        boolean botRight = contains(r.x + (r.width/2), r.y - (r.height/2));
        boolean botLeft = contains(r.x - (r.width/2), r.y - (r.height/2));
        if (topLeft == true && topRight == true && botLeft == true && botRight == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean overlaps(MyRectangle2D r){
        boolean topRight = contains(r.x + (r.width/2) , r.y + (r.height/2) );
        boolean topLeft = contains(r.x - (r.width/2), r.y +(r.height/2));
        boolean botRight = contains(r.x + (r.width/2), r.y - (r.height/2));
        boolean botLeft = contains(r.x - (r.width/2), r.y - (r.height/2));
        if(contains(r) == true){
            return false;
        }else if(topLeft == false && topRight == false && botLeft == false && botRight == false){
            return false;
        }else{
            return true;
        }
    }
}
