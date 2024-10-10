package com.perscholas.classworks.classExamples;

import java.util.ArrayList;
import java.util.List;

public class CalcRunner {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10.0);
        circle.setName("Circle");

        Triangle triangle = new Triangle();
        triangle.setHeight(2.0);
        triangle.setBase(5.0);
        triangle.setName("Triangle");

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(2.0);
        rectangle.setWidth(5.0);
        rectangle.setName("Rectangle");

        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(rectangle);

        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println("The area of the shape" + shape.getName() + " is " + area);
        }
    }
}
