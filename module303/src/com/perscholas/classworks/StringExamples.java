package com.perscholas.classworks;

public class StringExamples {
    public static void main(String[] args) {

        // 0 based indexing
        // index:   012345
        String s = "abcdef"; // this string length is 6
        // but the position is from 0 to 5

        // this will print the length of the string
        System.out.println("The length of the string is: " + s.length());

        System.out.println(s.charAt(0)); // should print 'a'
        System.out.println(s.charAt(5)); // should print 'f'
        // System.out.println(s.charAt(6)); // should print error because there is no index 6

        // other functions
        System.out.println(s.toUpperCase());
        System.out.println(s.concat("ghijk")); // concat is to + 2 strings together

    }
}
