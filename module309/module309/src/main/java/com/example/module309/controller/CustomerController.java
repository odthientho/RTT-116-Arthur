package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.User;
import com.example.module309.form.CreateCustomerFormBean;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(required = false) String firstName) {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/search");
        response.addObject("search", firstName);
        if (firstName != null) {
            List<Customer> customers = customerDAO.findByFirstName(firstName);
            response.addObject("customers", customers);
        }
        return response;
    }

    @GetMapping("/edit/{customerId}")
    public ModelAndView edit(@PathVariable Integer customerId) {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/create");
        Customer customer = customerDAO.findById(customerId);

        CreateCustomerFormBean form = new CreateCustomerFormBean();
        form.setId(customerId);
        form.setCustomerName(customer.getCustomerName());
        form.setContactFirstname(customer.getContactFirstname());
        form.setContactLastname(customer.getContactLastname());
        form.setPhone(customer.getPhone());
        form.setAddressLine1(customer.getAddressLine1());
        form.setAddressLine2(customer.getAddressLine2());
        form.setCity(customer.getCity());
        form.setState(customer.getState());
        form.setPostalCode(customer.getPostalCode());
        form.setCountry(customer.getCountry());
        form.setCreditLimit(customer.getCreditLimit());
        form.setSalesRepEmployeeId(customer.getSalesRepEmployeeId());
        response.addObject("form", form);

        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeeKey", employees);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView();
        List<Employee> employees = employeeDAO.findAllEmployees();
        response.addObject("employeeKey", employees);
        response.setViewName("customer/create");
        User loggedInUser = authenticatedUserService.loadCurrentUser();
        log.debug("loggedInUser: " + loggedInUser.toString());
        return response;
    }

    @PostMapping("/createOrUpdate")
    public ModelAndView createOrUpdate(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.error(error.getDefaultMessage());
            }
            response.setViewName("customer/create");
            response.addObject("form", form);
            List<Employee> employees = employeeDAO.findAllEmployees();
            response.addObject("employeeKey", employees);
            response.addObject("errors", bindingResult);
        } else {
            Customer customer = new Customer();
            if (form.getId() != null) customer.setId(form.getId());
            customer.setCustomerName(form.getCustomerName());
            customer.setContactFirstname(form.getContactFirstname());
            customer.setContactLastname(form.getContactLastname());
            customer.setPhone(form.getPhone());
            customer.setAddressLine1(form.getAddressLine1());
            customer.setAddressLine2(form.getAddressLine2());
            customer.setCity(form.getCity());
            customer.setState(form.getState());
            customer.setPostalCode(form.getPostalCode());
            customer.setCountry(form.getCountry());
            customer.setCreditLimit(form.getCreditLimit());
            Employee employee = employeeDAO.findById(form.getSalesRepEmployeeId());
            customer.setRepEmployee(employee);

            customerDAO.save(customer);
            response.setViewName("customer/search");
        }
        return response;
    }
}
