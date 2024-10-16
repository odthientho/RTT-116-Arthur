package com.perscholas.homeworks;

public class GLAB303_11_1_GenericMethod {
    public <T> void genericsMethod(T data) {
        System.out.println("Generi Method:");
        System.out.println("Data Passed: " + data);
    }
    public static void main(String[] args) {
        // initialize the class with Integer data
        GLAB303_11_1_GenericMethod dObj = new GLAB303_11_1_GenericMethod();
        dObj.genericsMethod(25); // passing int
        dObj.genericsMethod("Per Scholas"); // passing String
        dObj.genericsMethod(2563.5); // passing float
        dObj.genericsMethod('H'); // passing Char
    }
}
