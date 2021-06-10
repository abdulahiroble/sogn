package com.sogn.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "/";
    }

}
