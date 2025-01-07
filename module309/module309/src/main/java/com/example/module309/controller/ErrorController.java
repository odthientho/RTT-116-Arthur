package com.example.module309.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(NoResourceFoundException.class)
    @RequestMapping(value = "/error/404")
    public ModelAndView notFound() {
        ModelAndView response = new ModelAndView("/404");
        return response;
    }
}
