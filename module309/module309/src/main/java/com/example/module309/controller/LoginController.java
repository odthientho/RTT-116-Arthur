package com.example.module309.controller;

import com.example.module309.database.dao.UserDAO;
import com.example.module309.database.entity.User;
import com.example.module309.form.CreateUserFormBean;
import com.example.module309.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
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

import java.util.ArrayList;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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
    public ModelAndView signup(@Valid CreateUserFormBean formUser, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors()) {
            response.addObject("user", formUser);
            response.addObject("errors", bindingResult.getAllErrors().get(0).getDefaultMessage());
            response.setViewName("login/signupPage");
        } else {
            // just checking this to provide back the information to the page.
            // This can be achieved through validation
            if (userDAO.findByEmailIgnoreCase(formUser.getEmail()) == null) {
                response.setViewName("redirect:/");
                User user = new User();
                user.setEmail(formUser.getEmail());
                user.setPassword(passwordEncoder.encode(formUser.getPassword()));
                user.setFullName(formUser.getFullName());
                userDAO.save(user);
                authenticatedUserService.changeLoggedInUsername(session, formUser.getEmail(), formUser.getPassword());
            } else {
                response.addObject("errors", "This email is taken.");
                response.addObject("user", formUser);
                response.setViewName("login/signupPage");
            }
        }
        return response;
    }
}
