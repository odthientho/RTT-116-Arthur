package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public void update(Employee employee) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.merge(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void create(Employee employee) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteByProduct(Employee employee) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.delete(employee);
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
        Employee employee = (Employee) session.get(Employee.class, id);
        try {
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public Employee findById(int employeeId) {
        String hqlQuery = "SELECT e FROM Employee e WHERE id = :employeeId";
        Session session = factory.openSession();
        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);
        query.setParameter("employeeId", employeeId);
        try {
            Employee employee = query.getSingleResult();
            Hibernate.initialize(employee.getSupervisor());
            Hibernate.initialize(employee.getSubordinates());
            Hibernate.initialize(employee.getCustomers());
            return employee;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

}
