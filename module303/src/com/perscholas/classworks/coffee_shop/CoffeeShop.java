package com.perscholas.classworks.coffee_shop;

import java.text.DecimalFormat;
import java.util.*;

public class CoffeeShop {

    private Scanner myScanner = new Scanner(System.in);
    // this is a class level variable that will contain our list of products for sale
    private List<Product> products = new ArrayList<>();
    // this will hold the product that customers purchase
    // Map of product with quantity in the cart
    private Map<Product, Integer> cart = new HashMap<>();

    private void initProducts() {
        products.add(new Product("Small Coffee", 4.57));
        products.add(new Product("Large Coffee", 7.99));
        products.add(new Product("Sugar Cookie", 5.89));
        products.add(new Product("Chocolate Cookie", 5.89));
        products.add(new Product("Egg Sandwich", 6.49));
/**
        // sorted the list in the order of price
        // println each sorted products using toString override method
        // will not modify the original list
        List<Product> sortedProducts = new ArrayList<>(products.stream().sorted(Comparator.comparing(Product::getPrice)).toList());

        // this will modify the original list
        products.sort(Comparator.comparing(Product::getPrice).thenComparing(Product::getName));
        products.forEach(System.out::println);
 **/
        printSortedProducts(products);
    }

    private void printSortedProducts(List<Product> source) {
        for (int outer = 0; outer < source.size()-1; outer++) {
            for (int inner = outer + 1; inner < source.size(); inner++) {
                Product outerProduct = source.get(outer);
                Product innerProduct = source.get(inner);
                if (outerProduct.getPrice() > innerProduct.getPrice()) {
                    source.set(inner, outerProduct);
                    source.set(outer, innerProduct);
                }
            }
        }
        source.forEach(System.out::println);
    }

    private void printProductMenu() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("Product #" + (i + 1) + " \t| Name: " + product.getName() + " \t| Price: " + product.getPrice());
        }
    }
    private void searchProductMenu() {
        // TODO create a new main menu option that allows you to search the list of products for a user entered name
        System.out.print("Enter a keyword to search: ");
        String keyword = myScanner.nextLine();
        List<Product> filteredProducts = products.stream().filter(e -> e.getName().contains(keyword)).toList();
        if (filteredProducts.isEmpty()) {
            System.out.println("No products matched");
        } else filteredProducts.forEach(System.out::println);
    }

    private int readNumberFromUser(String question) {
        System.out.print(question);
        try {
            return myScanner.nextInt();
            // Java will still call finally !!!! //
        } catch (Exception e) {
            System.out.println("Invalid Input");
            return -1;
        } finally {
            myScanner.nextLine();
        }
    }

    private int printMainMenu() {
        System.out.println("*************************");
        System.out.println("Welcome to Coffee Shop!");
        System.out.println("1. Print product menu");
        System.out.println("2. Search product menu");
        System.out.println("3. Purchase product");
        System.out.println("4. Check Out");
        System.out.println("5. Exit");
        return readNumberFromUser("Enter your choice: ");
    }

    private void addProductToCart() {
        // print the menu for customer to choose
        printProductMenu();

        // ask which one they want to purchase
        int selection = readNumberFromUser("Enter product number: ");

        // make sure product selected in all products that have
        if (selection > 0 && selection <= products.size()) {
            Product product = products.get(selection - 1);
            int quantity = readNumberFromUser("How many? ");
            if (quantity <= 0) {
                System.out.println("Invalid Quantity");
            } else {
                // check if that selection product in the cart already or not
                // update real quantity
                if (cart.containsKey(product)) quantity += cart.get(product);
                cart.put(product, quantity);
                System.out.println("Added " + quantity + " of the product# " + selection + " to the cart");
            }
        } else System.out.println("Invalid Product Number");
    }
    private void checkOut() {
        // Format to 2 decimal places
        DecimalFormat df = new DecimalFormat("$#.##");
        double totalPrice = 0.0;
        for (Product product: cart.keySet()) {
            int quantity = cart.get(product);
            totalPrice += product.getPrice() * quantity;
            System.out.println(
                    "Name: " + product.getName() +
                            " \t| Quantity: " + quantity +
                            " \t| Unit Price: " + df.format(product.getPrice()) +
                            " \t| Price: " + df.format(product.getPrice() * quantity)
            );
        }
        System.out.println("Subtotal: \t\t\t" + df.format(totalPrice));
        System.out.println("Sale tax: \t\t\t" + df.format(totalPrice * 0.05));
        System.out.println("Total Price: \t\t" + df.format(totalPrice * 1.05));

        System.out.print("\nAre you ready to pay? [Y/N] ");
        char choice = myScanner.nextLine().toUpperCase().charAt(0);
        if (choice == 'Y') {
            System.out.println("Thank you for your payment!\nGood Bye!");
            System.exit(0);
        }
    }
    // This is where project starts
    public void start() {
        // 1) initialize the products for sale
        initProducts();
        do {
            int selection = printMainMenu();
            switch (selection) {
                case 1:
                    printProductMenu();
                    break;
                case 2:
                    searchProductMenu();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    checkOut();
                    break;
                case 5:
                    // let exit the system with status of 0 successful
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        } while (true);
    }

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.start();
    }
}
