package com.perscholas.classworks.M303_11;

import java.util.*;

public class ListSetExample {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        iList.add(3);
        iList.add(1);
        iList.add(2);
        iList.add(3);
        for (Integer i : iList) {
            System.out.println("List contains: " + i);
        }

        Set<Integer> iSet = new HashSet<>();
        iSet.add(3);
        iSet.add(6);
        iSet.add(9);
        iSet.add(10);
        iSet.add(22);
        iSet.add(1);
        iSet.add(3);
        iSet.add(4);
        iSet.add(2);
        iSet.add(3);
        for (Integer i : iSet) {
            System.out.println("Set contains: " + i);
        }

        // first we get the iterator in the list
        Iterator<Integer> iterator = iList.iterator();
        // loop through the list to make sure the list has a next element
        while (iterator.hasNext()) {
            // return the element at the pointer
            // move the pointer to next one
            Integer i = iterator.next();
            if (i==3) iterator.remove();
        }
        for (Integer i : iList) {
            System.out.println("List contains: " + i);
        }

    }
}
