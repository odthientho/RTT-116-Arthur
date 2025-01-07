package com.example.module309.controller;

import com.example.module309.database.dao.CustomerDAO;
import com.example.module309.database.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    // Spring Boot created DAO for us when started up
    // We do Autowired --> to create new DAO
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView();

        // this is our index.jsp
        response.setViewName("index");

        List<Customer> firstNames = customerDAO.findByFirstName("Alexander");
        response.addObject("names", firstNames);

        return response;
    }

    @GetMapping("/404")
    public ModelAndView notFound() {
        ModelAndView response = new ModelAndView();
        response.setViewName("404");
        return response;
    }
}
