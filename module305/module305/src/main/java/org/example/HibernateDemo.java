package org.example;

import org.example.database.dao.CustomerDAO;
import org.example.database.dao.EmployeeDAO;
import org.example.database.dao.OrderDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.example.database.entity.Product;

import java.util.List;
import java.util.Scanner;

public class HibernateDemo {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.findById(1056);
        System.out.println(employee);
        System.out.println(employee.getSupervisor());
        System.out.println(employee.getSubordinates());
        System.out.println(employee.getCustomers());

//        CustomerDAO customerDAO = new CustomerDAO();
//        Customer customer = customerDAO.findById(103);
//        Employee employee = customer.getRepEmployee();
//        System.out.println(customer);
//        System.out.println(employee);
//        List<Customer> customers = employee.getCustomers();
//        for (Customer c : customers) {
//            System.out.println(c);
//        }

//        ProductDAO productDAO = new ProductDAO();
//        Product product = productDAO.findById(103);
////        System.out.println(product);
//        product.setProductCode("ABC123");
//        productDAO.update(product);
//
//        List<Product> products = productDAO.search("Ford");
////        for (Product ford : products) {
////            System.out.println(ford);
////        }
//
////        Product product2 = new Product();
////        product2.setProductCode("123sdas");
////        product2.setProductName("Ford");
////        product2.setProductDescription("Ford");
////        product2.setProductScale("1:20");
////        product2.setBuyPrice(new BigDecimal("2.45"));
////        product2.setProductLineId(2);
////        product2.setProductVendor("Hello");
////        product2.setQuantityInStock(12);
////        product2.setMsrp(new BigDecimal("112.22"));
////
////        System.out.println("Before:" + product2);
////        productDAO.create(product2);
////        System.out.println("After" + product2);
//
////        Product product2 = productDAO.findById(112);
////        productDAO.delete(product2);
//
//        OrderDAO orderDAO = new OrderDAO();
//        System.out.println(orderDAO.findById(10100));
//
//        CustomerDAO customerDAO = new CustomerDAO();
//        List<Customer> customers = customerDAO.findByName("Carine","Schmitt");
//        for (Customer customer : customers) {
//            System.out.println(customer);
//            customerDAO.delete(customer);
//        }
//        ProductDAO productDAO = new ProductDAO();
//        List<Product> products = productDAO.findByOrderId(10100);
//        for (Product product : products) {
//            System.out.println(product);
//        }
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("Enter Order Id: ");
//            int orderId = Integer.parseInt(scanner.nextLine());
//            productDAO.findByOrderId(orderId);
//            for (Product product : products) {
//                System.out.println(product.getProductName() + " | " + product.getBuyPrice() + " | " + product.getQuantityInStock());
//            }
//            System.out.println("Exist? (Y/N)");
//            String answer = scanner.nextLine();
//            if (answer.toUpperCase().equals("Y")) System.exit(0);
//        }
    }
}
