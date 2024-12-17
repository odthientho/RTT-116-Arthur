package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.entity.Customer;
import com.example.module309.form.CreateCustomerFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
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
        response.addObject("form", form);

        return response;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView response = new ModelAndView();
        response.setViewName("customer/create");
        return response;
    }

    @PostMapping("/createOrUpdate")
    public String createOrUpdate(@Valid @ModelAttribute("form") CreateCustomerFormBean form, BindingResult bindingResult, Model model) {
        log.debug(form.toString());

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.error(error.getDefaultMessage());
            }
            model.addAttribute("errors", bindingResult);
            return "customer/create";
        }

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
        customer.setCreditLimit(customer.getCreditLimit());
        customerDAO.save(customer);

        return "redirect:/customer/search";
    }
}
