package com.perscholas.classworks.classExamples;

public class Main {
    public static void main(String[] args) {
        Rectangle re1 = new Rectangle();
        Rectangle re2 = new Rectangle(10, 20);
        System.out.println(re2.toString());
        System.out.println("The area is " + re2.calculateArea());
        System.out.println("The perimeter is " + re2.calculatePerimeter());

        System.out.println(re1.toString());
        System.out.println("The area is " + re1.calculateArea());
        System.out.println("The perimeter is " + re1.calculatePerimeter());

        re1.setHeight(30);
        re1.setWidth(15);
        System.out.println(re1.toString());
        System.out.println("The area is " + re1.calculateArea());
        System.out.println("The perimeter is " + re1.calculatePerimeter());

        // you can call notAvailable from here
        // because this method is private
        // re1.notAvailable();
    }
}
