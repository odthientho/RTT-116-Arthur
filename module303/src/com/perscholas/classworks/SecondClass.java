package com.perscholas.classworks;
import java.util.Scanner;

public class SecondClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        // Write your code here.
        if (s.equals("") || s == null) System.out.println("0");
        else {
            String[] words = s.split("[^A-Za-z]+");
            System.out.println(words.length);
            for (String word : words) System.out.println(word);
        }
        scan.close();
    }
}
