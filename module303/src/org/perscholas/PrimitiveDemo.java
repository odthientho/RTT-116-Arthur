package org.perscholas;

public class PrimitiveDemo {
    public static void main(String[] args) {
        byte byteNum;   // This can hold whole number between -128 and 127.
        byteNum = 113;
        System.out.println(byteNum);

        short shortNum;
        shortNum = 150;
        System.out.println(shortNum);

        long longNum = -12332252626L;
        System.out.println(longNum);

        double doubleNum = -42937737.9d;
        System.out.println(doubleNum);

        float floatNum = 19.98f;
        System.out.println(floatNum);

        boolean booleanVar = false;
        System.out.println(booleanVar);

        char character = 'Z';
        System.out.println(character);

        // This way is depreciated no longer the best way of creating new Integer
        Integer integerNum = 123;

        // it has been replaced with
        Integer integerNum2 = Integer.valueOf(123);

        final double PI = 3.14159265358979;
    }
}
