package com.perscholas.classworks;

import java.util.Arrays;

public class ArrayExamples {

    public static double[] insertArray(double[] array, int position, double value) {
        double[] newArray = new double[array.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < position) newArray[i] = array[i];
            else if (i == position) newArray[i] = value;
            else newArray[i] = array[i - 1];
        }
        return newArray;
    }

    public static double[] deleteArray(double[] array, int position) {
        if (position < 0 || position >= array.length) {
            System.out.println("Invalid position");
            return array; // return back the incoming array because we do not modify anything
        }
        double[] newArray = new double[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < position) newArray[i] = array[i];
            else newArray[i] = array[i+1];
        }
        return newArray;
    }

    public static double[] appendArray(double[] array, double value) {
        double[] newArray = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) newArray[i] = array[i];
        newArray[array.length] = value;
        return newArray;
    }

    public static void main(String[] args) {
        int[] numbers = new int[10];

        // print all elements of the array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        // arr by hard coding it
        // this will create a new int array with size of 6
        // and automatically fill the array with the given values
        int[] numbers2 = {1, 2, 3, 4, 5, 6};

        // this will create an array of size 5 with the given value
        String[] strings = {"one", "two", "three", "four", "five"};

        double[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(insertArray(num, 3, 3.5)));
        System.out.println(Arrays.toString(deleteArray(num, 7)));
        System.out.println(Arrays.toString(appendArray(num,2)));
    }
}
