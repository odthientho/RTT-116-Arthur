package com.perscholas.classworks.coffee_shop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

    private Scanner myScanner = new Scanner(System.in);
    // this is a class level variable that will contain our list of products for sale
    private List<Product> products = new ArrayList<>();
    // this will hold the product that customers purchase
    private List<Product> cart = new ArrayList<>();

    private void initProducts() {
        products.add(new Product("Small Coffee", 4.57, 0));
        products.add(new Product("Large Coffee", 7.99, 0));
        products.add(new Product("Sugar Cookie", 5.89, 0));
        products.add(new Product("Egg Sandwich", 6.49, 0));
    }

    private void printProductMenu() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("Product #" + (i+1) + " \t| Name: " + product.getName() + " \t| Price: " + product.getPrice());
        }
    }

    private int printMainMenu() {
        System.out.println("*************************");
        System.out.println("Welcome to Coffee Shop!");
        System.out.println("1. See product menu");
        System.out.println("2. Purchase product");
        System.out.println("3. Check Out");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int selection = myScanner.nextInt();
        myScanner.nextLine();
        return selection;
    }

    private void addProductToCart() {
        // print the menu for customer to choose
        printProductMenu();

        // ask which one they want to purchase
        System.out.print("Enter product number: ");
        int selection = myScanner.nextInt();
        myScanner.nextLine();

        // add the selected product to the cart
        if (selection >= 0 && selection < products.size()) {
            cart.add(products.get(selection - 1));
            System.out.println("Added product# " + selection +" to the cart");
        } else System.out.println("Invalid product number");
    }
    private void checkOut() {
        double totalPrice = 0;
        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);
            totalPrice += product.getPrice();
            System.out.println("Product #" + (i+1) + " \t| Name: " + product.getName() + " \t| Price: " + product.getPrice());
        }
        DecimalFormat df = new DecimalFormat("$#.##");  // Format to 2 decimal places
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
                    addProductToCart();
                    break;
                case 3:
                    checkOut();
                    break;
                case 4:
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
