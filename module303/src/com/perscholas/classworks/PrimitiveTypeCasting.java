package com.perscholas.classworks;

public class PrimitiveTypeCasting {
    public static void main(String[] args) {
        int x = 5;
        int y = 5/2;
        System.out.println(y);

        // diving 2 whole integers into a double result
        // giving the answer 2.0
        double z = 5/2;
        System.out.println(z);

        double a = 5.0 / 2.0;
        System.out.println(a);

        // Type casting
        // if we want the double type result: we put z = (double) 5/2;
        double b = (double) 5/2;
        System.out.println(b);
    }
}
