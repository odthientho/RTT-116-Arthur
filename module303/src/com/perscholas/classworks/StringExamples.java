package com.perscholas.classworks;

import java.text.DecimalFormat;
import java.util.StringJoiner;

public class StringExamples {
    public static void main(String[] args) {

        // 0 based indexing
        // index:   012345
        String s = "abcdef"; // this string length is 6
        // but the position is from 0 to 5

        // this will print the length of the string
        System.out.println("The length of the string is: " + s.length());

        System.out.println(s.charAt(0)); // should print 'a'
        System.out.println(s.charAt(5)); // should print 'f'
        // System.out.println(s.charAt(6)); // should print error because there is no index 6

        // other functions
        System.out.println(s.toUpperCase());
        System.out.println(s.concat("ghijk")); // concat is to + 2 strings together

        // substring from index to index (not length of the substring)
        System.out.println(s.substring(1, 4));

        String r = "abc123abc";
        // have to assign the out result into the r
        System.out.println(r.replace("a", "z"));
        System.out.println(r.replace("abc", "xyz"));

        System.out.println(r.replaceAll("\\d", "x"));

        // --- Substrings ---
        String filename = "someimage.jpg";
        // position that first . appearance
        System.out.println(filename.indexOf('.'));
        // position that last . appearance
        System.out.println(filename.lastIndexOf('.'));

        // get the name of the file
        System.out.println(filename.substring(0, filename.lastIndexOf('.')));
        // Get the format of the file
        System.out.println(filename.substring(filename.lastIndexOf('.') + 1));

        String s1 = new String("abc");
        String s2 = new String("aBc");

        // *********  very IMPORTANT ************* //

        // this is never correct for strings
        System.out.println(s1 == s2);

        // ALWAYS correct way to compare 2 strings
        System.out.println(s1.equals(s2));
        // compares 2 string without case of sensitivity
        System.out.println(s1.equalsIgnoreCase(s2));

        String n = "101";
        int n1 = Integer.parseInt(n);
        System.out.println(n1);

        // String in Java are immutable
        // They cannot be changed when they are created.
        // They introduce StringBuffer as a peer class of String
        StringBuffer sb = new StringBuffer();
        sb.append("abc");
        sb.append("123");

        sb.insert(4, "xyz");
        System.out.println(sb);

        // replace function for String Buffer
        // start at position 0 position 3 but NOT INCLUDE the position 3
        sb.replace(0, 3, "ABCDEF");
        System.out.println(sb);

        // we can delete from a string buffer
        sb.delete(0, 3);
        System.out.println(sb);
        // reverse the string
        sb.reverse();
        System.out.println(sb);

        // KBA Questions
        StringBuffer kba = new StringBuffer("ABC");
        kba.replace(0, 7, "DEFG").insert(0, "12345");
        System.out.println(kba);
        // should be 12345DEFG
        kba.reverse();
        System.out.println(kba);
        // should be GFED54321
        kba.delete(0, 5);
        System.out.println(kba);
        // should be 4321

        // **** STRINGJOINER ****
        StringJoiner joinNames = new StringJoiner(" | ", "{ ", " }");
        joinNames.add("Eric");
        joinNames.add("Arthur");

        System.out.println(joinNames);

        StringJoiner joinNames2 = new StringJoiner(" : ", "| ", " |");
        joinNames2.add("Anna");
        joinNames2.add("Tho");

        System.out.println(joinNames2);

        System.out.println(joinNames.merge(joinNames2));
        // StringJoiner merge 2 stringjoiners will merge 2 datas together
        // BUT keep prefix, suffix of the FIRST one
        // the delimiter of the 1, then 2nd

        // ****** DECIMAL FORMAT *******
        String pattern = "#,###,###.##";
        double number = 123456789.123;
        DecimalFormat numberFormat = new DecimalFormat(pattern);
        System.out.println(number);
        System.out.println(numberFormat.format(number));

        // null is its own built in part of the language
        // no memory has been allocated and this simply a variable has no value
        String str = null;
        // --> check if s exists saying s == null;
        if (str == null) System.out.println("This checks if it exists");
        else System.out.println("The string exists");

        // NullPointerException
        // if you use str.toUpperCase() or any methods it will run Exception!
        // str.trim(); str.length() etc.
        if (str == null || str.length() == 0) System.out.println("empty string");

        // you never compare 2 strings by the operator ==
        // should compare by method equal
        // however, the problem of str null.
        // this run exceptions
        if (str != null && str.equals("")) {
            System.out.println("This check for an empty string");
        }
    }
}
