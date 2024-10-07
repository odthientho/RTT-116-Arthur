package com.perscholas.homeworks;

import java.util.Scanner;

public class PA303_4_1_ConditionalStatements {

    // 1. Write a program that declares 1 integer variable x, and then assigns 7 to it.
    // Write an if statement to print out “Less than 10” if x is less than 10.
    // Change x to equal 15, and notice the result (console should not display anything).
    public static void taskOne() {
        int x = 7;
        if (x < 10) System.out.println("Less than 10");
        x = 15;
        if (x < 10) System.out.println("Less than 10");
    }

    // 2. Write a program that declares 1 integer variable x, and then assigns 7 to it.
    // Write an if-else statement that prints out “Less than 10” if x is less than 10,
    // and “Greater than 10” if x is greater than 10.
    // Change x to 15 and notice the result.
    public static void taskTwo() {
        int x = 7;
        if (x < 10) System.out.println("Less than 10");
        else System.out.println("Greater than 10");
        x = 15;
        if (x < 10) System.out.println("Less than 10");
        else System.out.println("Greater than 10");
    }

    // 3. Write a program that declares 1 integer variable x, and then assigns 15 to it.
    // Write an if-else-if statement that prints out “Less than 10” if x is less than 10;
    // “Between 10 and 20” if x is greater than 10 but less than 20,
    // and “Greater than or equal to 20” if x is greater than or equal to 20.
    // Change x to 50 and notice the result.
    public static void taskThree() {
        int x = 15;
        if (x < 10) System.out.println("Less than 10");
        else if (x >= 10 && x < 20) System.out.println("Between 10 and 20");
        else System.out.println("Greater than or equal to 20");

        x = 50;
        if (x < 10) System.out.println("Less than 10");
        else if (x >= 10 && x < 20) System.out.println("Between 10 and 20");
        else System.out.println("Greater than or equal to 20");
    }

    // 4. Write a program that declares 1 integer variable x, and then assigns 15 to it.
    // Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20
    // and prints “In range” if the number is between 10 and 20 (including equal to 10 or 20).
    // Change x to 5 and notice the result.
    public static void taskFour() {
        int x = 15;
        if (x < 10 || x > 20) System.out.println("Out of range");
        else System.out.println("In range");

        x = 5;
        if (x < 10 || x > 20) System.out.println("Out of range");
        else System.out.println("In range");
    }

    // 5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F,
    // according to the following criteria:
    //A: 90-100
    //B: 80-89
    //C: 70-79
    //D: 60-69
    //F: <60
    // Use the Scanner class to accept a number score from the user to determine the letter grade.
    // Print out “Score out of range” if the score is less than 0 or greater than 100.
    public static void taskFive() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter number");
        int x = myScanner.nextInt();
        if (x < 0 || x > 100) System.out.println("Score out of range");
        else if (x < 60) System.out.println("F");
        else if (x < 70) System.out.println("D");
        else if (x < 80) System.out.println("C");
        else if (x < 90) System.out.println("B");
        else System.out.println("A");
    }

    // 6. Write a program that accepts an integer between 1 and 7 from the user.
    // Use a switch statement to print out the corresponding weekday.
    // Print “Out of range” if the number is less than 1 or greater than 7.
    // Do not forget to include “break” statements in each of your cases.
    public static void taskSix() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter number");
        int x = myScanner.nextInt();
        switch (x) {
            case 1: System.out.println("Sunday"); break;
            case 2: System.out.println("Monday"); break;
            case 3: System.out.println("Tuesday"); break;
            case 4: System.out.println("Wednesday"); break;
            case 5: System.out.println("Thursday"); break;
            case 6: System.out.println("Friday"); break;
            case 7: System.out.println("Saturday"); break;
            default: System.out.println("Out of range");
        }
    }

    // 7. Create a program that lets the users input their filing status and income.
    // Display how much tax the user would have to pay according to status and income.
    //The U.S. federal personal income tax is calculated based on the filing status and taxable income.
    //There are four filing statuses: Single, Married Filing Jointly, Married Filing Separately, and Head of Household.
    //The tax rates for 2009 are shown below.
    public static void taskSeven() {
        System.out.println("=================");
        System.out.println("1. Single");
        System.out.println("2. Married Filing Jointly");
        System.out.println("3. Married Filing Separately");
        System.out.println("4. ead of Household");
        System.out.println("=================");
        System.out.println("Please enter 1-4 for your filing statuses:");
        Scanner myScanner = new Scanner(System.in);
        int statuse = myScanner.nextInt();
        System.out.println("Please enter your total income:");
        double income = myScanner.nextDouble();
        double taxRate = 0.35;
        switch (statuse) {
            case 1: {
                if (income <= 8350) taxRate = 0.1;
                else if (income <= 33950) taxRate = 0.15;
                else if (income <= 82250) taxRate = 0.25;
                else if (income <= 171550) taxRate = 0.28;
                else if (income <= 372950)  taxRate = 0.33;
                break;
            }
            case 2: {
                if (income <= 16700) taxRate = 0.1;
                else if (income <= 67900) taxRate = 0.15;
                else if (income <= 137050) taxRate = 0.25;
                else if (income <= 208850) taxRate = 0.28;
                else if (income <= 372950)  taxRate = 0.33;
                break;
            }
            case 3: {
                if (income <= 8350) taxRate = 0.1;
                else if (income <= 33950) taxRate = 0.15;
                else if (income <= 68525) taxRate = 0.25;
                else if (income <= 104425) taxRate = 0.28;
                else if (income <= 186475)  taxRate = 0.33;
                break;
            }
            case 4: {
                if (income <= 11950) taxRate = 0.1;
                else if (income <= 45500) taxRate = 0.15;
                else if (income <= 117450) taxRate = 0.25;
                else if (income <= 190200) taxRate = 0.28;
                else if (income <= 372950)  taxRate = 0.33;
                break;
            }
        }
        System.out.println("Your tax paying: " + income * taxRate);
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
    }
}
