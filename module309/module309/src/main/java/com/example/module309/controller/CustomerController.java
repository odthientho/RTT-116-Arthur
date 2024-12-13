package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.dao.EmployeeDAO;
import com.example.module309.database.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

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
    public String create(@ModelAttribute("customer") Customer customer) {
       System.out.println("Customer object: " + customer);
        // System.out.println("Sales Rep Employee ID: " + customer.getSalesRepEmployeeId());
//        Employee employee = employeeDAO.findById(customer.getSalesRepEmployeeId());
//        customer.setRepEmployee(employee);
      //  customerDAO.save(customer);
        return "customer/create";
    }
}
