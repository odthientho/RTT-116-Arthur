package com.perscholas.homeworks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PA303_7_1_Array {
    // Task 1: Write a program that creates an array of integers with a length of 3.
    // Assign the values 1, 2, and 3 to the indexes. Print out each array element.
    public static void task1() {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // Task 2: Write a program that returns the middle element in an array.
    // Give the following values to the integer array: {13, 5, 7, 68, 2} and produce the following output: 7
    public static int task2(int[] arr) {
        int middle = (int) arr.length / 2;
        return arr[middle];
    }
    // Task 3: Write a program that creates an array of String type and
    // initializes it with the strings “red,” “green,” “blue,” and “yellow.”
    // Print out the array length. Make a copy using the clone( ) method.
    // Use the Arrays.toString( ) method on the new array to verify that the original array was copied.
    public static void task3() {
        String[] arr = new String[4];
        arr[0] = "red";
        arr[1] = "green";
        arr[2] = "blue";
        arr[3] = "yellow";
        System.out.println(arr.length);
        String[] arr2 = arr.clone();
        // always use equals to compare strings
        if (Arrays.toString(arr).equals(Arrays.toString(arr2))) {
            System.out.println("The original array was copied.");
        } else System.out.println("Not copied");
    }
    // Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers).
    // The numbers can be any integers.
    // Print out the value at the first index and the last index using length - 1 as the index.
    // Now try printing the value at index = length (e.g., myArray[myArray.length] ).
    // Notice the type of exception which is produced. Now try to assign a value to the array index 5.
    // You should get the same type of exception.
    public static void task4() {
        int[] numbers = new int[]{6, 3, 8, 10, 11};
        System.out.println("The first value of numbers: " + numbers[0]);
        System.out.println("The last value of numbers: " + numbers[numbers.length-1]);
        // These 2 lines will throw exception
        // System.out.println(numbers[numbers.length]]);
        // numbers[5] = 1;
    }
    // Task 5: Write a program where you create an integer array with a length of 5.
    // Loop through the array and assign the value of the loop control variable (e.g., i)
    // to the corresponding index in the array.
    public static void task5() {
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        for (int number : numbers) System.out.print(number + " ");
        System.out.println();
    }
    // Task 6: Write a program where you create an integer array of 5 numbers.
    // Loop through the array and assign the value of the loop control variable multiplied by 2
    // to the corresponding index in the array.
    public static void task6() {
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i*2;
        }
        for (int number : numbers) System.out.print(number + " ");
        System.out.println();
    }
    // Task 7: Write a program where you create an array of 5 elements.
    // Loop through the array and print the value of each element, except for the middle (index 2) element.
    public static void task7() {
        int[] numbers = new int[] { 1, 2, 3, 4, 5 };
        for (int i = 0; i < numbers.length; i++) {
            if (i != 2) System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
    // Task 8: Write a program that creates a String array of 5 elements and
    // swaps the first element with the middle element without creating a new array.
    public static void task8() {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        int temp = numbers[0];
        numbers[0] = numbers[numbers.length/2];
        numbers[numbers.length/2] = temp;
        for (int number : numbers) System.out.print(number + " ");
        System.out.println();
    }
    // Task 9:
    // Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}.
    // Print the array in ascending order, and print the smallest and the largest element of the array.
    // The output will look like the following:
    // Array in ascending order: 0, 1, 2, 4, 9, 13
    // The smallest number is 0
    // The biggest number is 13
    public static void task9() {
        int[] numbers = new int[] {4, 2, 9, 13, 1, 0};
        // the sort uses Quicksort in ascending order
        Arrays.sort(numbers);
        System.out.print("Array in ascending order: ");
        for (int number : numbers) System.out.print(number + " ");
        System.out.println();
        System.out.println("The smallest number is " + numbers[0]);
        System.out.println("The biggest number is " + numbers[numbers.length-1]);
    }
    // Task 10: Create an array that includes an integer, 3 strings, and 1 double. Print the array.
    public static void task10() {
        Object[] obj = new Object[5];
        obj[0] = 1;
        obj[1] = "arthur";
        obj[2] = "tho";
        obj[3] = "ong";
        obj[4] = 9.3;
        for (Object o: obj) System.out.println(o);
    }
    // Task 11: Write some Java code that asks the user how many favorite things they have.
    // Based on their answer, you should create a String array of the correct size.
    // Then ask the user to enter the things and store them in the array you created.
    // Finally, print out the contents of the array.
    public static void task11() {
        System.out.println("How many favorite things do you have?");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] favThings = new String[num];
        for (int i = 0; i < num; i++) {
            System.out.println("Enter your thing: ");
            favThings[i] = scanner.nextLine();;
        }
        System.out.println("Your favorite things are: ");
        for (String favThing : favThings) System.out.print(favThing + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        task1();
        System.out.println(task2(new int[]{12, 5, 7, 68, 2}));
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
    }
}
