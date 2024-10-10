package com.perscholas.classworks.classExamples;

public class Rectangle extends Shape {
    // these are considered class members or clas variables
    // we are not directly exposing these to outside world.
    // Thus they are private class member
    private double height;
    private double width;

    // this is the constructor to initialize when we create an object.
    public Rectangle() {
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(double height, double width) {
        // use this. -> reference to the parameters of the class
        this.height = height;
        this.width = width;
    }

    // this is what we call setters and getters
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    // this method is on all java objects nad is used to return a string representation of the object
    public String toString() {
        return "Square [height=" + height + ", width=" + width + "]";
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        notAvailable();
        return height * 2 + width * 2;
    }

    // protected: is ok to call under the same packages
    private void notAvailable() {
        System.out.println("Not available");
    }
}
