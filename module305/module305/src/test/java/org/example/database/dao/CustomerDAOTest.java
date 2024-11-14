package org.example.database.dao;

import org.example.database.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerDAOTest {
    private CustomerDAO customerDAO = new CustomerDAO();

    @Test
    public void testFindById() {
        int givenCustomerId = 125;
        String expectedCustomerName = "Havel & Zbyszek Co";

        Customer actualCustomer = customerDAO.findById(givenCustomerId);

        Assertions.assertNotNull(actualCustomer);

        Assertions.assertEquals(givenCustomerId, actualCustomer.getId());
        Assertions.assertEquals(expectedCustomerName, actualCustomer.getCustomerName());
    }

    @Test
    public void testFindByIdNull() {
        Customer customer = customerDAO.findById(1);
        Assertions.assertNull(customer);
    }
}
