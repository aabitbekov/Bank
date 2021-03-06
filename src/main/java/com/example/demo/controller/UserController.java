package com.example.demo.controller;
;
import com.example.demo.UserCreatorFormValidator;
import com.example.demo.resources.UserCreateForm;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCreatorFormValidator userCreatorFormValidator;

    @InitBinder("registerForm")
    public void registerFormInitBinder(WebDataBinder binder) {

        binder.addValidators(userCreatorFormValidator);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(){
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("registerForm") UserCreateForm userCreateForm) {
        return "register";

    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registrationForm") UserCreateForm userCreateForm,
                                      BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerUser(userCreateForm);
        return "redirect:/login";
    }


}
