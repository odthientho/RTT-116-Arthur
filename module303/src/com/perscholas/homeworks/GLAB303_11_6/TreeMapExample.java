package com.perscholas.homeworks.GLAB303_11_6;

import java.util.TreeMap;
import java.util.Comparator;
class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String number1, String number2) {
        return -number1.compareTo(number2);
    }
}


public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        System.out.println("TreeMap: " + numbers);
        // remove method with single parameter
        int value = numbers.remove("Two");
        System.out.println("Removed value: " + value);
        // remove method with two parameters
        boolean result = numbers.remove("Three", 3);
        System.out.println("Is the entry {Three=3} removed? " + result);
        System.out.println("Updated TreeMap: " + numbers);

        TreeMap<String, Integer> numbersTree = new TreeMap<>();
        numbersTree.put("First", 1);
        numbersTree.put("Second", 2);
        numbersTree.put("Third", 3);
        System.out.println("TreeMap: " + numbersTree);
        // Using the firstKey() method
        String firstKey = numbersTree.firstKey();
        System.out.println("First Key: " + firstKey);
        // Using the lastKey() method
        String lastKey = numbersTree.lastKey();
        System.out.println("Last Key: " + lastKey);
        // Using firstEntry() method
        System.out.println("First Entry: " + numbersTree.firstEntry());
        // Using the lastEntry() method
        System.out.println("Last Entry: " + numbersTree.lastEntry());

        TreeMap<String, Integer> nums = new TreeMap<>(new CustomComparator());
        nums.put("First", 1);
        nums.put("Second", 2);
        nums.put("Third", 3);
        nums.put("Fourth", 4);
        System.out.println("TreeMap: " + nums);
    }
}
