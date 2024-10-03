public class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome to Java!");
        System.out.println("this is a \"new line\"");

        // this is string literal meaning that new string is created set value to it
        String x = "arthur";
        System.out.println(x.toUpperCase()); // print string to upper case
        String y = x;
        if (x == y) System.out.println(x + " is equal to " + y);
        System.out.println(y.toUpperCase());
        y = "king";
        System.out.println(x.toUpperCase());
        System.out.println(y.toUpperCase());

        String a = new String("arthur");
        String b = new String("arthur");
        if (a == b) {
            System.out.println("The strings reference the same object.");
        } else {
            System.out.println("The strings reference different objects.");
        }
    }
}