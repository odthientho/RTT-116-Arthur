package com.perscholas.classworks.classExamples;

public class Circle extends Shape {
    private double radius;
    private static double PI = 3.1415;
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setPI(double PI) {
        this.PI = PI;
    }
    public double getPI() {
        return PI;
    }
}
