package com.perscholas.homeworks.GLAB303_10_2_AND_303_10_3;

public class Cylinder extends Circle {
    private final double PI = Math.PI  ;

    public Cylinder(double radius, double height) {
        super(radius, height);
        // TODO Auto-generated constructor stub
    }

    public Cylinder(double radius) {
        super(radius);
    }

    /** Returns the volume of this cylinder */
    public double getVolumne() {
        return  (PI*Math.pow(super.radius, 2)) * super.height;
    }

    public double getSurfaceArea() {
        return 2.0 * Math.PI*super.radius*super.height;
    }

    @Override
    public void displayshapeName() {
        System.out.println("Drawing a Cylinder for radius " + super.radius);
    }

    @Override
    public String toString() {
        return "radius is: " + super.radius +"height is : " + super.height;
    }
}
