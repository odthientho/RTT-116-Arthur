package com.perscholas.classworks.M303_12;

public class ExceptionExample {
    public static void main(String[] args) {
        int[] nunbers = {1, 2, 3, 4, 5};
        // this will throw exception!
        try {
            // Null pointer
            String s2 = null;
            s2.toUpperCase();
            //Out of Bounds
            System.out.println(nunbers[10]);
            // Arithmetic
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            // specifically catching only Arithmetic Exception
            System.out.println("Exception Arithmetic: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            // specifically catching only ArrayIndexOutOfBoundsException
            System.out.println("Exception: " + e.getMessage());
        } catch (NullPointerException e ) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // Optional: this code will execute nomatter what
            // Both success or fail
            System.out.println("<-- finally -->");
        }
    }
}
