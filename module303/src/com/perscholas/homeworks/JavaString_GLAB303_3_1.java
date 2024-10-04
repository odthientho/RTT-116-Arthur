package com.perscholas.homeworks;
import java.util.Arrays;

public class JavaString_GLAB303_3_1 {

    public static void lengthMethod() {
        String str1 = "Java";
        String str2 = "";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println("Java".length());  // 4
        System.out.println("Java\n".length()); // 5
        System.out.println("Learn Java".length()); // 10
    }

    public static void isEmptyMethod() {
        String s1 = "";
        String s2 = "hello";
        System.out.println(s1.isEmpty());      // true
        System.out.println(s2.isEmpty());      // false
    }

    public static void trimMethod() {
        String s1="  hello   ";
        System.out.println(s1 + "how are you");        // without trim()
        System.out.println(s1.trim() + " how are you");
    }

    public static void toLowerCaseMethod() {
        String s1 = "HELLO HOW Are You?";
        String s1lower = s1.toLowerCase();
        System.out.println(s1lower);
    }

    public static void toUpperCaseMethod() {
        String s1 = "hello how are you";
        String s1upper = s1.toUpperCase();
        System.out.println(s1upper);
    }

    public static void concatMethod() {
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

    public static void splitMethod() {
        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));
    }

    public static void charAtMethod() {
        String message = "Welcome to Java";
        System.out.println("The first character in the message is " + message.charAt(0));
    }

    public static void compareToMethod() {
        String s1="hello";
        String s2="hello";
        String s3="hemlo";
        String s4="flag";
        System.out.println(s1.compareTo(s2)); // 0 because both are equal
        System.out.println(s1.compareTo(s3)); //-1 because "l" is only one time lower than "m"
        System.out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"
    }

    public static void subStringMethod() {
        String str1 = "java is fun";
        // extract substring from index 0 to 3
        // starting position 0 of the string, and move on 4 characters, which is index 3
        System.out.println(str1.substring(0, 4));
    }

    public static void indexOfMethod() {
        String str1 = "Java is fun";
        int result;

        // getting index of character 's'
        result = str1.indexOf('s');

        System.out.println(result); // 6

        // getting index of character 'J'
        result = str1.lastIndexOf('J');
        System.out.println(result); // 0

        // the last occurrence of 'a' is returned
        result = str1.lastIndexOf('a');
        System.out.println(result); // 3

        // character not in the string
        result = str1.lastIndexOf('j');
        System.out.println(result); // -1

        // getting the last occurrence of "ava"
        result = str1.lastIndexOf("ava");
        System.out.println(result); // 1

        // substring not in the string
        result = str1.lastIndexOf("java");
        System.out.println(result); // -1
    }

    public static void containsMethod() {
        String str1 = "Learn Java";
        Boolean result;

        // check if str1 contains "Java"
        result = str1.contains("Java");
        System.out.println(result);  // true

        // check if str1 contains "Python"
        result = str1.contains("Python");
        System.out.println(result);  // false

        // check if str1 contains ""
        result = str1.contains("");

        System.out.println(result);
    }

    public static void replaceMethod() {
        String str1 = "abc cba";
        // all occurrences of 'a' is replaced with 'z'
        System.out.println(str1.replace('a', 'z'));
        // all occurences of 'L' is replaced with 'J'
        System.out.println("Lava".replace('L', 'J'));
        // character not in the string
        System.out.println("Hello".replace('4', 'J'));
        // all occurrences of "C++" is replaced with "Java"
        System.out.println("C++ Java & C+".replace("C++", "Java"));
        // all occurences of "aa" is replaced with "zz"
        System.out.println("aa bb aa zz".replace("aa", "zz"));
        // substring not in the string
        System.out.println("Java".replace("C++", "C"));
    }

    public static void replaceAllMethod() {
        String str1 = "Java123is456fun";
        // replace all occurrences of numeric
        // digits by a space
        System.out.println(
                // replace all numbers to space
                str1.replaceAll("\\d", " ")
                        // replace all continuous space into one space only
                        .replaceAll("\\s+", " ")
        );
    }

    public static void equalsMethod() {
        String s1 = "PerScholas";
        String s2 = "PerScholas";
        String s3 = new String("PerScholas");
        String s4 = "Teksystem";
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s1.equals(s4));//false
    }

    public static void equalsOperatorsMethod() {
        String s1 = "Perscholas";
        String s2 = "Perscholas";
        String s3 = new String("Perscholas");
        System.out.println(s1 == s2);//true (because both refer to same instance)
        System.out.println(s1 == s3);//false(because s3 refers to instance created in nonpool)
    }

    public static void main(String[] args) {
        System.out.println("*** length Method ***");
        lengthMethod();
        System.out.println("*** isEmpty Method ***");
        isEmptyMethod();
        System.out.println("*** trim Method ***");
        trimMethod();
        System.out.println("*** toUpperCase Method ***");
        toLowerCaseMethod();
        System.out.println("*** toUpperCase Method ***");
        toUpperCaseMethod();
        System.out.println("*** concat Method ***");
        concatMethod();
        System.out.println("*** split Method ***");
        splitMethod();
        System.out.println("*** charAt Method ***");
        charAtMethod();
        System.out.println("*** compareTo Method ***");
        compareToMethod();
        System.out.println("*** substring Method ***");
        subStringMethod();
        System.out.println("*** indexOf Method ***");
        indexOfMethod();
        System.out.println("*** contains Method ***");
        containsMethod();
        System.out.println("*** replace Method ***");
        replaceMethod();
        System.out.println("*** replaceAll Method ***");
        replaceAllMethod();
        System.out.println("*** equals Method ***");
        equalsMethod();
        System.out.println("*** equals operators Method ***");
        equalsOperatorsMethod();
    }
}
