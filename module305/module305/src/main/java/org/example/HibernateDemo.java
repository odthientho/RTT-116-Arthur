package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        System.out.println(productDAO.findById(103));
    }
}
