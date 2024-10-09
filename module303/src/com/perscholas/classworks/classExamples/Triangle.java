package com.perscholas.classworks.classExamples;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    private double base;
    private double height;

    public Triangle() {
        sideA = 0;
        sideB = 0;
        sideC = 0;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

}
