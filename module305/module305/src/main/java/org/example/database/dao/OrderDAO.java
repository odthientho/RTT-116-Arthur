package org.example.database.dao;

import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(order);
        session.getTransaction().commit();
        session.close();
    }

    public Order findById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class, id);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Order order = session.get(Order.class, id);
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
    }
}
