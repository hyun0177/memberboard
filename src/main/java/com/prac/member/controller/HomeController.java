package com.prac.member.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/api")
    public String index(){
        return "index";
    }
}
