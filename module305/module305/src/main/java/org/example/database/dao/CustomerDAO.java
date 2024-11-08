package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Customer;
import org.example.database.entity.Employee;
import org.example.database.entity.OrderDetail;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(customer);
        session.getTransaction().commit();
        session.close();
    }

    public Customer findById(int customerId) {
        String hqlQuery = "SELECT c FROM Customer c WHERE id = :customerId";
        Session session = sessionFactory.openSession();
        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);
        query.setParameter("customerId", customerId);
        try {
            Customer customer = query.getSingleResult();
            Hibernate.initialize(customer.getRepEmployee());
            // have to close the session at the end to tell hibernate to give the connection back to the pool
            return customer;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Customer> findByName(String firstName, String lastName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hqlQuery = "SELECT c FROM Customer c WHERE c.contactFirstname = :firstName AND c.contactLastname = :lastName";
        TypedQuery<Customer> query = session.createQuery(hqlQuery, Customer.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        try {
            List<Customer> customers = query.getResultList();
            session.getTransaction().commit();
            return customers;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

}
