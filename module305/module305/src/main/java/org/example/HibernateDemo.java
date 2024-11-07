package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(103);
        System.out.println(product);
        product.setProductCode("ABC123");
        productDAO.update(product);

        List<Product> products = productDAO.search("Ford");
        for (Product ford : products) {
            System.out.println(ford);
        }
    }
}
