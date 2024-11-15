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

    @Test
    public void testCreateCustomer() {
        // given: customer
        Customer givenCustomer = new Customer();
        givenCustomer.setCustomerName("Test");
        givenCustomer.setCity("Test");
        givenCustomer.setState("Test");
        givenCustomer.setCountry("Test");
        givenCustomer.setPhone("Test");
        givenCustomer.setAddressLine1("Test");
        givenCustomer.setAddressLine2("Test");
        givenCustomer.setContactFirstname("Test");
        givenCustomer.setContactLastname("Test");
        givenCustomer.setCreditLimit(1000.0);
        givenCustomer.setPostalCode("Test");

        customerDAO.create(givenCustomer);
    }
}
