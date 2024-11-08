package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    // old style: make session factory for all DAO
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     *
     * @param product
     */
    public void update(Product product) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
        session.close();
    }

    /**
     *
     * @param product
     */
    public void create(Product product) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        session.close();
    }

    /**
     *
     * @param product
     */
    public void deleteByProduct(Product product) {
        // for hibernate
        // update: the product has already existed to work without error
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void deleteById(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        try {
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public Product findById(int productId) {
        // the sql to running on database
        // this native sql
        String nativeSqlQuery = "select * from products where id = ?";

        // hibernate sql: use java names from the JAVA entities
        String hqlQuery = "SELECT p FROM Product p WHERE id = :productId";

        // this is needed to get database connection and let hibernate run the query
        Session session = factory.openSession();

        // hibernate uses this typedquery to execute the query
        // and fill "hybrate" the entity with the data from the database
        // passing the HQL query and setting the datatype for hibernate to use
        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);

        // passing parameter to productId
        query.setParameter("productId", productId);

        // get the result(s)
        try {
            Product product = query.getSingleResult();
            // have to close the session at the end to tell hibernate to give the connection back to the pool
            return product;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<Product> findByOrderId(int orderId) {
        Session session = factory.openSession();
//        String hqlQuery = "SELECT p FROM Product p, OrderDetail od WHERE p.id = od.productId AND od.orderId = :orderId";
        String hqlQuery = "SELECT p FROM Product p WHERE p.id IN (SELECT od.productId FROM OrderDetail od WHERE od.orderId = :orderId)";
        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);
        query.setParameter("orderId", orderId);
        try {
            List<Product> products = query.getResultList();
            return products;
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    /**
     *
     * @param name
     * @return a list of products having @param name in its product name
     */
    public List<Product> search(String name) {
        String hqlQuery = "SELECT p FROM Product p WHERE p.productName LIKE :productName";
        Session session = factory.openSession();
        TypedQuery<Product> query = session.createQuery(hqlQuery, Product.class);
        query.setParameter("productName", "%" + name + "%");
        try {
            List<Product> products = query.getResultList();
            return products;
        } catch (Exception e) {
            // if there is no results / errors, we will have to return list of nothing
            return new ArrayList<Product>();
        } finally {
            session.close();
        }
    }

}
