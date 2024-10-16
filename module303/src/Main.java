//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static long countNumberOfSubarrays(int[] arr, int k) {
        // Write your code here
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (sum < k) sum += arr[j];
                else break;
            }
            if (sum == k) count++;
        }
        return count;
    }

    public int getDigitsSum(int largeNumber) {
        int sum = 0 ;
        while (largeNumber > 0) {
            sum += (largeNumber % 10);
            largeNumber /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
//
//        int x, y = 10, z = 3;
//        int tooBig = Integer.MAX_VALUE + 1; // it becomes the smallest integer
//        System.out.println(tooBig);
//
//        double radius;
//        double area;
//        radius = 4;
//        final double PI_NUMBER = 3.14159;
//        area = radius * radius * PI_NUMBER;
//        System.out.println("The area of the circle that has a radius of " + radius + "is : " + area);
//        int[] arr = {10, 2, -2, -20, 10};
//        System.out.println("KQ: " + countNumberOfSubarrays(arr, -10));
//
//        char one = '1';
//        int num = one - '0';
//        System.out.println(num);
        System.out.println(new Main().getDigitsSum(9999));
    }
}