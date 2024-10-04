package com.perscholas.classworks;

public class WrapperClassesExample {

    public static void autobox(Integer x) {
        System.out.println("Function called with " + x);
    }

    public static void booleanAutoBox(boolean x) {
        System.out.println("Function called with " + x);
    }

    public static void main(String[] args) {
        int x = 5;
        Integer y = x;

        Integer z = Integer.valueOf(x);

        autobox(x);
        autobox(y);
        autobox(z);

        // all java objects can be null
        Integer value = null;
        // but not a primitive, it cannot be null
        // int v1 = null (not correct)


        Boolean b = null;
        // you can not pass that Boolean b into the function
        // because you cannot pass the null Boolean into boolean value
        // booleanAutoBox(b);
        b = true;
        booleanAutoBox(b);
    }
}
