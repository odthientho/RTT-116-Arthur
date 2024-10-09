package com.perscholas.classworks.classExamples;

public class Rectangle extends Shape {
    // these are considered class members or clas variables
    // we are not directly exposing these to outside world.
    // Thus they are private class member
    private int height;
    private int width;

    // this is the constructor to initialize when we create an object.
    public Rectangle() {
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(int height, int width) {
        // use this. -> reference to the parameters of the class
        this.height = height;
        this.width = width;
    }

    // this is what we call setters and getters
    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // this method is on all java objects nad is used to return a string representation of the object
    public String toString() {
        return "Square [height=" + height + ", width=" + width + "]";
    }

    public int calculateArea() {
        return width * height;
    }

    public int calculatePerimeter() {
        notAvailable();
        return height * 2 + width * 2;
    }

    // protected: is ok to call under the same packages
    private void notAvailable() {
        System.out.println("Not available");
    }
}
