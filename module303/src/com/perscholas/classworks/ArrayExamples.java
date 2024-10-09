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

    public static double[] bubbleSort(double[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static double average(double[] nums) {
        if (nums.length == 0) return 0;
        double sum = 0;
        for (double num: nums) sum += num;
        return sum / nums.length;
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

        double[] sorting = {2, 4, 1, 6, 3, 9, 5, 7, 8};
        System.out.println(Arrays.toString(bubbleSort(sorting)));
        System.out.println("Average of the array is: " + average(sorting));

        int[] values = new int[] {3, 5, 2, 7, 10, 6, 1, 14, 8, 13};
        if (values == null || values.length == 0) return;
        int min = values[0];
        int max = values[0];
        for (int v: values) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        System.out.println("Minimum value is: " + min);
        System.out.println("Maximum value is: " + max);
    }
}
