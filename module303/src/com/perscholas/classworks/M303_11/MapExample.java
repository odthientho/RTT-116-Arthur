package com.perscholas.classworks.M303_11;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // This creates a newhash map where they key is of type string
        // the value is Integer
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("ten", 10);
        // The key is unique, the value is anything
        // the later same key, will override the original value

        // now we can retrieve things from the map using the key
        Integer x = numbers.get("one");
        Integer y = numbers.get("two");

        for (String key: numbers.keySet()) {
            Integer value = numbers.get(key);
            System.out.println("Key " + key + " matching " + value);
        }

        // it will return null, meaning not existed
        System.out.println("not found " + numbers.get("tenn"));

        // we can also loop over the values of the hashmap
        for (Integer value: numbers.values()) {
            System.out.println("value " + value);
        }
    }
}
