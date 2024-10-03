package com.perscholas.classworks;
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        System.out.println("Enter a number: ");

        // create a new scanner and use the input from the system (keyboard)
        Scanner myScanner = new Scanner(System.in);
        int x = myScanner.nextInt(); // Attempt to read an integer, the system is waiting for your input
        System.out.println("You entered: " + x);

        System.out.println("Enter the radius: ");
        double r = myScanner.nextDouble();
        // Have to put this line in order to get the real next line
        // we input enter so the nextLine of Scanner read will be 'blank' and do not ask and await for you next
        // Scanner nextLine reading because it is already in the nextLine
        myScanner.nextLine();
        System.out.println("You have entered the radius of " + r);
        double area = r * r * Math.PI;
        System.out.println("The area of " + r + " is " + area);

        // This is a good practice for good!
        // IMPORTANT
        System.out.println("Enter your name: ");
        String newLine = myScanner.nextLine();
        System.out.println("Your name entered is " + newLine);
    }
}
