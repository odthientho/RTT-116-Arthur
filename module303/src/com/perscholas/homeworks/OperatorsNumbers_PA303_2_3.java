package com.perscholas.homeworks;

public class OperatorsNumbers_PA303_2_3 {
    // Task 1:
    // Write a program that declares an integer a variable x, assigns the value 2 to it,
    // and prints out the binary string version of the number ( Integer.toBinaryString(x) ).
    // Now, use the left shift operator (<<) to shift by 1 and assign the result to x.
    // Before printing the results, write a comment with the predicted decimal value and binary string.
    // Now, print out x in decimal form and in binary notation.
    private void taskOne(int number) {
        int x = number;
        // the decimal 2 equals to the binary 10
        System.out.println(Integer.toBinaryString(x));
        x = x << 1;
        // the decimal will be 4 and binary is 100
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
    }

    // Task 2:
    // Write a program that declares a variable x, and assigns 150 to it,
    // and prints out the binary string version of the number.
    // Now use the right shift operator (>>) to shift by 2 and assign the result to x.
    // Write a comment indicating what you anticipate the decimal and binary values to be.
    // Now print the value of x and the binary string.
    private void taskTwo(int number) {
        int x = number;
        System.out.println(Integer.toBinaryString(x));
        x = x >> 2;
        // 10010110 shift >> 2 equals to 100101 in binary and 37 in decimal
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
    }

    // Write a program that declares three int variables: x, y, and z. Assign 7 to x and 17 to y.
    // Write a comment that indicates what you predict will be the result of the bitwise and operation on x and y.
    // Now use the bitwise AND (&) operator to derive the decimal and binary values, and assign the result to z.
    private void taskThree() {
        int x = 7;
        int y = 17;
        // x = 111
        // y = 10001
        // z = 00001 or 1 in decimal
        int z = x & y;
        System.out.println(z);
        System.out.println(Integer.toBinaryString(z));
    }

    // Now, with the preceding values, use the bitwise and operator to calculate the “or” value between x and y.
    // As before, write a comment that indicates what you predict the values to be before printing them out.
    private void taskFour() {
        int x = 7;
        int y = 17;
        // x = 111
        // y = 10001
        // z = 10111 or 23 in decimal
        int z = x | y;
        System.out.println(z);
        System.out.println(Integer.toBinaryString(z));
    }

    // Write a program that declares an integer variable, assigns a number,
    // and uses a postfix increment operator to increase the value.
    // Print the value before and after the increment operator.
    private void taskFive() {
        int a = 5;
        System.out.println(a++);
        System.out.println(++a);
    }

    // Write a program that demonstrates at least three ways to increment a variable by 1
    // and does this multiple times.
    // Assign a value to an integer variable, print it, increment by 1, print it again,
    // increment by 1, and then print it again.
    private void taskSix() {
        int a = 3;
        a = a + 1;
        System.out.println(a);
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);
        a += 1;
        System.out.println(a);
    }

    // Write a program that declares two integer variables: x, and y,
    // and then assigns 5 to x and 8 to y.
    // Create another variable sum and assign the value of ++x added to y, and print the result.
    // Notice the value of the sum (should be 14).
    // Now change the increment operator to postfix (x++) and re-run the program.
    // Notice what the value of the sum is. The first configuration incremented x,
    // and then calculated the sum, while the second configuration calculated the sum, and then incremented x.
    private void taskSeven() {
        int x = 5;
        int y = 8;
        int sum = ++x + y;
        System.out.println(sum);
        sum = x++ + y;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        OperatorsNumbers_PA303_2_3 opNum = new OperatorsNumbers_PA303_2_3();
        // to run task 1
        // Perform the preceding exercise with the following values:
        // 2
        // 9
        // 17
        // 88
        System.out.println("Task 1: ");
        opNum.taskOne(2);
        opNum.taskOne(9);
        opNum.taskOne(17);
        opNum.taskOne(88);

        // to run task 2
        // Perform the preceding exercise with the following values:
        // 150
        // 225
        // 1555
        // 32456
        System.out.println("Task 2: ");
        opNum.taskTwo(150);
        opNum.taskTwo(225);
        opNum.taskTwo(1555);
        opNum.taskTwo(32456);

        System.out.println("Task 3: ");
        opNum.taskThree();

        System.out.println("Task 4: ");
        opNum.taskFour();

        System.out.println("Task 5: ");
        opNum.taskFive();

        System.out.println("Task 6: ");
        opNum.taskSix();

        System.out.println("Task 7: ");
        opNum.taskSeven();
    }
}
