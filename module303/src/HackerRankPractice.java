import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
public class HackerRankPractice {

    static void ItemSeparator(String rawInput) {
        String[] split = rawInput.split("\\$\\$##");
        String name = split[0];
        double price = Double.parseDouble(split[1]);
        int quantity = Integer.parseInt(split[2]);
    }

    static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        // Write your code here
        int duplicates = 0;
        Set<String> productSet = new HashSet<>();
        for (int i = 0; i < name.size(); i++) {
            String product = name.get(i) + price.get(i).toString() + weight.get(i).toString();
            if (!productSet.add(product)) duplicates++;
        }
        return duplicates;
    }
    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        // Write your code here
        int indexA = 0;
        int indexB = 0;
        List<Integer> merge = new ArrayList<>();
        while (indexA < a.size() || indexB < b.size()) {
            int aValue = indexA >= a.size() ? -1 : a.get(indexA);
            int bValue = indexB >= b.size() ? -1 : b.get(indexB);
            if (bValue == -1 || (aValue < bValue && aValue != -1)) {
                merge.add(aValue);
                indexA++;
            }
            if (aValue == -1 || (bValue <= aValue && bValue != -1)) {
                merge.add(bValue);
                indexB++;
            }
        }
        return merge;
    }

    public static String simpleCipher(String encrypted, int k) {
        // Write your code here
        String result = "";
        for (int i =0; i < encrypted.length() ; i++) {
            int ascii = (int)encrypted.charAt(i) - (int)k%26;
            result += (char)(ascii >= 65? ascii : 26+ascii);
        }
        return result;
    }

    public static void main(String[] args) {
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(5);
//        a.add(7);
//        a.add(7);
//        List<Integer> b = new ArrayList<>();
//        b.add(0);
//        b.add(1);
//        b.add(2);
//        b.add(3);
//        System.out.println(mergeArrays(a, b));
//        Animal myAnimal = new Dog();
//        myAnimal.makeSound();
//        ItemSeparator("bread$$##11.23$$##10");

//        List<String> name = new ArrayList<>();
//        name.add("ball");
//        name.add("box");
//        name.add("box");
//        name.add("ball");
//        name.add("ball");
//        List<Integer> price = new ArrayList<>();
//        price.add(1);
//        price.add(1);
//        price.add(1);
//        price.add(1);
//        price.add(1);
//        List<Integer> weight = new ArrayList<>();
//        weight.add(1);
//        weight.add(1);
//        weight.add(1);
//        weight.add(1);
//        weight.add(1);
//        System.out.println(numDuplicates(name, price, weight));
        System.out.println(simpleCipher("A",1));
    }
}