package com.perscholas.classworks;

public class IfStatement {
    public static void main(String[] args) {

        double radius = 21;
        // It is always best practice to put curly brackets after if statement
        // even if it is one line of codes
        if (radius > 20) System.out.println("The radius is greater than 20");
        else if (radius > 10) System.out.println("The radius is greater than 10");
        else System.out.println("The radius is less than or equal to 10");

        // booleans
        // if not specified, if statement compares it to true
        boolean condition = true;
        if (condition) {
            // this is same as if (condition == true)
            System.out.println("The condition is true");
        }
        if (!condition) {
            // this is same as if (condition == false)
            System.out.println("The condition is false");
        }

        // compound conditionals
        // Short-circuiting means ... in this case if condition is false the JVM will not even evaluate the radius
        if (condition && radius == 50) {
            // both conditions are true
        } else {
            // one condition or the other is false or both are false
        }
        if (condition || radius == 50) {
            // if either condition or both are true then execute here
            // this is also Short-circuiting when condition is true JVM will not evaluate the other one!
        } else {
            // execute here
        }

        // Problem: Determining Leap Year
        // This program first prompts the user to enter a year as an int, and checks if it is a leap year.
        // A year is a leap year if it is divisible by 4 but not by 100, or it is divisible by 400.
        int year = 2024;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("The year is a leap year");
        }

        // Switch Statement
        int grade = 90;
        // grade 0-60 F, 61-70 D, etc
        switch (grade) {
            case 90: System.out.println("The grade is 90"); break;
            case 80: System.out.println("The grade is 80"); break;
            default: System.out.println("The grade is unknown");
        }
    }
}
