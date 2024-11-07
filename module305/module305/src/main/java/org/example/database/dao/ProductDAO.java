package org.example.database.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
    // old style: make session factory for all DAO
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

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
}
