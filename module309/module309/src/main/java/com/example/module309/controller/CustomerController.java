package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.form.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

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

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/create");
        return response;
    }

    @PostMapping("/create")
    public String create(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/create");
        System.out.println(form);

        Customer customer = new Customer();
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
        customer.setCreditLimit(customer.getCreditLimit());
        customerDAO.save(customer);

        return "redirect:/customer/search";
    }
}
