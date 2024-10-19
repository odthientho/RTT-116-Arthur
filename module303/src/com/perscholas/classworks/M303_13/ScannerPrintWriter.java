package com.perscholas.classworks.M303_13;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerPrintWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter file = new FileWriter("src/temp2.txt");
            PrintWriter pw = new PrintWriter(file);
            System.out.print("Enter what you want: ");
            String input;
            while ((input = sc.nextLine()) != null && !input.equals("")) {
                pw.println(input);
                pw.flush();
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
