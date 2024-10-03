package com.perscholas.homeworks;
import java.util.Arrays;

public class JavaString_GLAB303_3_1 {

    private void lengthMethod() {
        String str1 = "Java";
        String str2 = "";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println("Java".length());  // 4
        System.out.println("Java\n".length()); // 5
        System.out.println("Learn Java".length()); // 10
    }

    private void isEmptyMethod() {
        String s1 = "";
        String s2 = "hello";
        System.out.println(s1.isEmpty());      // true
        System.out.println(s2.isEmpty());      // false
    }

    private void trimMethod() {
        String s1="  hello   ";
        System.out.println(s1 + "how are you");        // without trim()
        System.out.println(s1.trim() + " how are you");
    }

    private void toLowerCaseMethod() {
        String s1 = "HELLO HOW Are You?";
        String s1lower = s1.toLowerCase();
        System.out.println(s1lower);
    }

    private void toUpperCaseMethod() {
        String s1 = "hello how are you";
        String s1upper = s1.toUpperCase();
        System.out.println(s1upper);
    }

    private void concatMethod() {
        //------By using concat method----
        String str1 = "Learn ";
        String str2 = "Java";
        // concatenate str1 and str2
        System.out.println(str1.concat(str2)); // "Learn Java"

        // concatenate str2 and str1
        System.out.println(str2.concat(str1)); // "JavaLearn "
        //--- By using + operator---
        String str3 =  "hello";
        String str4 = "Learners";
        //  String str5 = str3.concat(str4); or
        String str5 = str3 + str4;
        System.out.println(str5);

        // Three strings are concatenated
        String message = "Welcome " + "to " + "Java";
        System.out.println(message);

        // String Chapter is concatenated with number 2
        String s = "Chapter " + 2; // s becomes Chapter2

        // String Supplement is concatenated with character B
        String s1 = "Supplement" + 'B'; // s1 becomes SupplementB
    }

    private void splitMethod() {
        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));
    }

    private void charAtMethod() {
        String message = "Welcome to Java";
        System.out.println("The first character in the message is " + message.charAt(0));
    }

    private void compareToMethod() {
        String s1="hello";
        String s2="hello";
        String s3="hemlo";
        String s4="flag";
        System.out.println(s1.compareTo(s2)); // 0 because both are equal
        System.out.println(s1.compareTo(s3)); //-1 because "l" is only one time lower than "m"
        System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"
    }

    private void subStringMethod() {
        String str1 = "java is fun";
        // extract substring from index 0 to 3
        // starting position 0 of the string, and move on 4 characters, which is index 3
        System.out.println(str1.substring(0, 4));
    }

    public static void main(String[] args) {
        JavaString_GLAB303_3_1 myJavaString = new JavaString_GLAB303_3_1();
        myJavaString.lengthMethod();
        myJavaString.isEmptyMethod();
        myJavaString.trimMethod();
        myJavaString.toLowerCaseMethod();
        myJavaString.toUpperCaseMethod();
        myJavaString.concatMethod();
        myJavaString.splitMethod();
        myJavaString.charAtMethod();
        myJavaString.compareToMethod();
        myJavaString.subStringMethod();
    }
}
