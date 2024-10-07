package com.perscholas.homeworks;

import java.text.DecimalFormat;

public class PA303_5_1_Loops {

    // Write a program that uses nested for loops to print a multiplication table.
    public static void multiplicationTable(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }
    }

    public static void greatestCommonDivisor(int num1, int num2) {
        int greatestCommonDivisor = 1;

        // 1. Work with for loop
        int smaller = Math.min(num1, num2);
        for (int i = 2; i <= smaller; i++) {
            if (num1 % i == 0 && num2 % i == 0) greatestCommonDivisor = i;
        }
        System.out.println(greatestCommonDivisor);
        // 2. Work with while loop
        int i = 2;
        while (i <= num1 && i <= num2) {
            if (num1 % i == 0 && num2 % i == 0) greatestCommonDivisor = i;
            i++;
        }
        System.out.println(greatestCommonDivisor);
    }

    public static void predictFutureTuition() {
        int year = 0;
        double tuition = 10000;
        do {
            year = year + 1;
            tuition = tuition * 1.07;
            System.out.println("in the year of " + year +
                    ", \ttuition is " + new DecimalFormat("#.##").format(tuition));
        } while (tuition < 20000);
    }

    public static void main(String[] args) {
        multiplicationTable(12);
        greatestCommonDivisor(8, 4);
        predictFutureTuition();
    }
}
