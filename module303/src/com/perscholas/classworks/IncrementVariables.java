package com.perscholas.classworks;

public class IncrementVariables {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        int c;
        // the ++ after is a post operation
        // assign the value to c first, then increment b
        c = b++;
        System.out.println("Value of c = b++, c = " + c + " and b = " + b);
        // the ++ before is a pre operation
        // first increment the value of a, then assign the value to c first
        c = ++a;
        System.out.println("Value of c = a++, c = " + c + " and a = " + a);
    }
}
