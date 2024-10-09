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
        Student[] stu = new Student[2];
        stu[0] = new Student(1, "Arthur", "Ong");
        stu[1] = new Student(2, "James", "Bob", "bobJames@gmail.com", "000-000-0001");
        stu[0].showInfo();
        stu[1].showInfo();
    }
}
