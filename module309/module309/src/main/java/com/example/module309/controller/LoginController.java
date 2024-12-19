package com.example.module309.controller;

import com.example.module309.database.dao.UserDAO;
import com.example.module309.database.entity.Employee;
import com.example.module309.database.entity.User;
import com.example.module309.form.CreateUserFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/loginPage");
        return response;
    }

    @GetMapping("signup")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();
        response.setViewName("login/signupPage");
        return response;
    }

    @PostMapping("signup")
    public ModelAndView signup(@Valid CreateUserFormBean user, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("errors", bindingResult);
            response.setViewName("login/signupPage");
        } else {
            User checkingUser = userDAO.findByEmailIgnoreCase(user.getEmail());
            if (checkingUser == null) {
                response.setViewName("redirect:/login/login");
                User newUser = new User();
                newUser.setEmail(user.getEmail());
                newUser.setPassword(passwordEncoder.encode(user.getPassword()));
                newUser.setFullName(user.getFullName());
                userDAO.save(newUser);
            } else {
                response.addObject("errors", "Already having this email");
                response.setViewName("login/signupPage");
            }
        }
        return response;
    }
}
