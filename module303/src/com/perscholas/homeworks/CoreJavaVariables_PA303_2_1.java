package com.perscholas.homeworks;

public class CoreJavaVariables_PA303_2_1 {
    public static void main(String[] args) {
        // Write a program that declares two integer variables,
        // assigns an integer to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        int int1 = 2024;
        int int2 = 10;
        var sumOfInt = int1 + int2;
        System.out.println(sumOfInt);

        // Write a program that declares two double variables,
        // assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        double double1 = 3.14159265;
        double double2 = 4.12;
        var sumOfDouble = double1 + double2;
        System.out.println(sumOfDouble);

        // Write a program that declares an integer variable and a double variable,
        // assigns numbers to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        // What variable type must the sum be?
        int int3 = 26;
        double double3 = 6.231;
        var sum1 = int3 + double3;
        System.out.println(sum1);

        // Write a program that declares two integer variables, assigns an integer to each,
        // and divides the larger number by the smaller number. Assign the result to a variable.
        // Print out the result. Now change the larger number to a decimal.
        // What happens? What corrections are needed?
        int int4 = 53;
        int int5 = 12;
        var division1 = int4 / int5;
        System.out.println(division1);
        double divisionOfInt2Double = (double) int4 / int5;
        System.out.println(divisionOfInt2Double);
        // the division between integers results into an integer.
        // once you assign the result into var, it understands the division as integer
        // if you assign the division result into a double, the result is still rounded
        // Unless you declare dataType of the result before (double)

        // Write a program that declares two double variables, assigns a number to each,
        // and divides the larger by the smaller number.
        // Assign the result to a variable. Print out the result.
        // Now, cast the result to an integer. Print out the result again.
        double double4 = 3.214;
        double double5 = 1.354;
        double divisionOfDouble2Double = double4 / double5;
        System.out.println(divisionOfDouble2Double);
        int divisionOfDouble2Int = (int) (double4 / double5);
        System.out.println(divisionOfDouble2Int);
        // Again, if you want to keep the decimal number, you assign the result into double
        // If you just want to keep the integer, you assign the result into int

        // Write a program that declares two integer variables, x and y,
        // and assigns the number 5 to x and the number 6 to y.
        // Declare a variable q and assign y/x to it and print q.
        // Now, cast y to a double and assign it to q. Print q again.
        int x = 3;
        int y = 6;
        var q = y/x;
        System.out.println(q);
        var q2 = (double) y/x;
        System.out.println(q2);
        // you cannot reassign them into var q again, because after the first one, it understands as integer
        // you have to create a new q2 var so that you can see the result

        // Write a program that declares a named constant and uses it in a calculation.
        // Print the result.
        final double PI = 3.14159265;
        double radius = 3.2;
        double circumference = 2 * PI * radius;
        System.out.println(circumference);
        // the formula to calculate the circumference of a circle with radius

        // Write a program where you create three variables that represent products at a cafe.
        // The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
        // Assign prices to each product. Create two more variables called subtotal and totalSale
        // and complete an “order” for three items of the first product, four items of the second product,
        // and two items of the third product. Add them all together to calculate the subtotal.
        // Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount.
        // Be sure to format the results to two decimal places.
        double price1 = 3;
        double price2 = 2;
        double price3 = 6;
        double subTotal = 3 * price1 + 4 * price2 + 2 * price3;
        System.out.println(subTotal);
        final double SALE_TAX = 0.08; // aka 8%
        double totalSale = subTotal*(1+SALE_TAX);
        System.out.println(String.format("%.2f",totalSale));
    }
}
