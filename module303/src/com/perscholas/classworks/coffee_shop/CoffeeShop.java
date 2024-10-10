package com.perscholas.classworks.coffee_shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

    private Scanner myScanner = new Scanner(System.in);
    // this is a class level variable that will contain our list of products for sale
    private List<Product> products = new ArrayList<Product>();

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
        System.out.println("Enter your choice: ");
        int selection = myScanner.nextInt();
        return selection;
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
                    System.out.println("Purchase product");
                    break;
                case 3:
                    System.out.println("Check Out");
                    break;
                case 4:
                    // let exit the system with status of 0 successful
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
            System.out.println();
        } while (true);
    }

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.start();
    }
}
