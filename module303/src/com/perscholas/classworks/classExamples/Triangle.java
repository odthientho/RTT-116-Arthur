package com.perscholas.classworks.classExamples;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle() {
        base = 0;
        height = 0;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}
