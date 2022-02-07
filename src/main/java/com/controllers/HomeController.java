package com.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal/*To tell Spring to inject the currently logged in principal*/ User activeUser,
                       Model model) {
        model.addAttribute("currentUser", "Logged in: " +
                activeUser.getUsername() + " with roles: "
                + activeUser.getAuthorities().toString());
        return "home";
    }
}
