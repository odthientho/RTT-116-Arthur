package com.perscholas.homeworks;

import java.util.Scanner;

public class ForLoop_GLAB303_5_1 {
    public static void Example1() {
        int n = 5;
        // for loop
        for (int i = 1; i <= n; ++i) {
            System.out.println("Java is fun");
        }
    }

    public static void Example2() {
        int sum = 0;
        int n = 1000;
        // for loop
        for (int i = 1; i <= n; ++i) {
            // body inside for loop
            sum += i;     // sum = sum + i
        }
        System.out.println("Sum = " + sum);
    }

    public static void Example3() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string/number to check if it is a palindrome");
        String original = in.nextLine();
        String reverse = ""; // Objects of String class

        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);

        if (original.equals(reverse)) System.out.println("Entered string/number is a palindrome.");
        else System.out.println("Entered string/number isn't a palindrome.");

        // another solution
        // convert into StringBuilder because String does not have .reverse method
        StringBuilder originalString = new StringBuilder(original);
        reverse = originalString.reverse().toString();
        if (original.equals(reverse)) System.out.println("Entered string/number is a palindrome.");
        else System.out.println("Entered string/number isn't a palindrome.");
    }

    public static void Example4() {
        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();//new line
        }
    }

    public static void main(String[] args) {
        System.out.println("Display a text Five Times");
        Example1();
        System.out.println("Display Sum of n Natural Numbers");
        Example2();
        System.out.println("Palindrome");
        Example3();
        System.out.println("Pyramid");
        Example4();
    }
}
