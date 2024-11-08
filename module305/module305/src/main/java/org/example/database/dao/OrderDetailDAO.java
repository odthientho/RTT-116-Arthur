package org.example.database.dao;

import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDetailDAO {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(OrderDetail orderDetail) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(orderDetail);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(OrderDetail orderDetail) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(orderDetail);
        session.getTransaction().commit();
        session.close();
    }

    public void update(OrderDetail orderDetail) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(orderDetail);
        session.getTransaction().commit();
        session.close();
    }

    public OrderDetail findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        OrderDetail orderDetail = (OrderDetail) session.get(OrderDetail.class, id);
        session.getTransaction().commit();
        session.close();
        return orderDetail;
    }
}
