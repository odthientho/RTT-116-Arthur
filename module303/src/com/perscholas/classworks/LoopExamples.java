package com.perscholas.classworks;

import java.util.ArrayList;
import java.util.List;

public class LoopExamples {
    public static void main(String[] args) {
        // FOR LOOPS

        // this is the original 1970s for loop and it works for when you want to count
        // or do something a set number of times
        // this is also good for position within an array or string

        // count up
        for (int count = 0; count < 10; count++) {
            System.out.println("For loop iteration: " + count);
        }
        // count down
        for (int count = 10; count >= 1; count--) {
            System.out.println("For loop iteration: " + count);
        }
        // loops for array
        // the array is 0-based, meaning the position if from 0 - 4
        String[] stringArray = {"one", "two", "three", "four", "five"};
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Strings at position "+ i + " = " + stringArray[i]);
        }
        // new style for loops for array
        for (String value: stringArray) {
            System.out.println("Strings include: " + value);
        }
        // loops for a string
        // array length does not need () but string length needs ()
        String characters = "abcdefg";
        for (int i = 0; i < characters.length(); i++) {
            System.out.println("Character at position "+ i + " = " + characters.charAt(i));
        }
        for (Character character: characters.toCharArray()) {
            System.out.println("Character = " + character);
        }
        // looping over a List
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        // List needs method of size to get the length
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("string at list position "+ i + " = " + stringList.get(i));
        }
        // *** new style of for loops
        // easy for typing & reading
        // but does not contain position of the list
        for (String s : stringList) {
            System.out.println(s);
        }

        // WHILE LOOPS

        // this would create a infinite loop
//        while (true) {
//            System.out.println("Do you want to continue? (y/n)");
//        }

        // while loops have some kind of condition
        // this is very similar to a for loop and really a for loop is better than
        String words = "abcdefg";
        int pos = 0;
        while (pos < words.length()) {
            System.out.println("word at position "+ pos + " = " + words.charAt(pos));
            pos = pos + 1;
        }
        // great example for use of a while loop
        boolean success = false;
        while (!success) {
            // make an API call attempt
            // if (apiCall is true)
            success = true;
        }

        // DO WHILE LOOPS
        // same as while loops except the condition at the end of the loop
        do {
        } while (!success);
    }
}
