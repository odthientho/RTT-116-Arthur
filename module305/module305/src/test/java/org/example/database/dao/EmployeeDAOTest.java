package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private static Employee createdEmployee = new Employee();

    @Test
    @Order(1)
    public void testCreate() {
        // given
        Employee givenEmployeee = new Employee();
        givenEmployeee.setFirstName("FirstName");
        givenEmployeee.setLastName("LastName");
        givenEmployeee.setEmail("email@email.com");
        givenEmployeee.setOfficeId(1);
        givenEmployeee.setReportsTo(1143);
        givenEmployeee.setVacationHours(20);
        givenEmployeee.setJobTitle("Sales Rep");

        // actual
        Assertions.assertNull(givenEmployeee.getId());
        employeeDAO.create(givenEmployeee);

        // assert
        Assertions.assertNotNull(givenEmployeee.getId());
        createdEmployee = givenEmployeee;
    }

    @Test
    @Order(2)
    public void testFindById() {
        // given in static createdEmployee (Employee) variable

        //actual
        Employee actual = employeeDAO.findById(createdEmployee.getId());

        // test
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(createdEmployee.getId(), actual.getId());
        Assertions.assertEquals(createdEmployee.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(createdEmployee.getLastName(), actual.getLastName());
    }

    @Test
    @Order(3)
    public void testFindByFirstName() {
        // given in static createdEmployee (Employee) variable

        // actual
        List<Employee> employees = employeeDAO.findByFirstName(createdEmployee.getFirstName());

        // test
        Assertions.assertNotNull(employees);
        Assertions.assertFalse(employees.isEmpty());
        Assertions.assertEquals(1, employees.size());
        for (Employee employee : employees) {
            Assertions.assertEquals(createdEmployee.getFirstName(), employee.getFirstName());
        }
    }

    @Test
    @Order(4)
    public void testUpdate() {
        // given in static createdEmployee (Employee) variable
        createdEmployee.setEmail("NewEmail@email.com");

        // actual
        employeeDAO.update(createdEmployee);

        // assert
        Assertions.assertNotNull("NewEmail@gmail.com",createdEmployee.getEmail());
    }

    @Test
    @Order(5)
    public void testDelete() {
        // given in static createdEmployee (Employee) variable

        // actual
        employeeDAO.delete(createdEmployee);
        Employee actual = employeeDAO.findById(createdEmployee.getId());

        // assert
        Assertions.assertNull(actual);
    }
}
