package com.perscholas.classworks.M303_12;

public class CustomException extends Exception {
    // when making a custom exception the naming practice is to always end with the word Exception
    // Making your own custom exception
    // 1. Extends Exception
    // 2. create a constructor that takes a string and calls super to initialize the parent

    public CustomException(String message) {
        super(message);
    }
}
