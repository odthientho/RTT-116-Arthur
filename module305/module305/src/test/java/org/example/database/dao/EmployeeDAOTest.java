package org.example.database.dao;

import org.example.database.entity.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDAOTest {
    private static Employee createdEmployee = new Employee();
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @ParameterizedTest
    @CsvSource({
            "FirstName, LastName, email@email.com, 1, 1143, 20, Sales Rep"
    })
    @Order(1)
    public void testCreate(String firstName, String lastName, String email, int officeId, int salesRep, int vacationHours, String jobTitle) {
        // given
        Employee givenEmployeee = new Employee();
        givenEmployeee.setFirstName(firstName);
        givenEmployeee.setLastName(lastName);
        givenEmployeee.setEmail(email);
        givenEmployeee.setOfficeId(officeId);
        givenEmployeee.setReportsTo(salesRep);
        givenEmployeee.setVacationHours(vacationHours);
        givenEmployeee.setJobTitle(jobTitle);

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
        for (Employee aEmployee : employees) {
            Assertions.assertEquals(createdEmployee.getFirstName(), aEmployee.getFirstName());
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
