package com.perscholas.classworks.M303_14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        // Print through the list in its Uppercase
        // this is lamda expression!!!
        list.stream().forEach(e -> {
            System.out.println(e.toUpperCase());
            // more lines of code can be here.
        });

        // fast way of removing an item that match an description
        boolean isRemoved = list.removeIf(e -> e.startsWith("o"));
        if (isRemoved) {
            System.out.println(list.size());
            list.stream().forEach(e -> {
                System.out.println(e.toUpperCase());
            });
        }

        List<String> filteredList = list.stream().filter(e -> e.startsWith("t")).toList();
    }
}
