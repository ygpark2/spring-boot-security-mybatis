package com.kdn.kevcs.mobile.web.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Young Gyu Park
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("Home Page");
        return "index";
    }

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    String map(@AuthenticationPrincipal User userDetails) {
        return "map";
    }

    @RequestMapping(value = "/auth/page", produces = "text/plain;charset=utf-8")
    String authPage(@AuthenticationPrincipal User userDetails) {
        return "Hello " + userDetails.getUsername() + " " + userDetails.getAuthorities() + "!";
    }
}