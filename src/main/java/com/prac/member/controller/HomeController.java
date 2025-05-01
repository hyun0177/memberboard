package com.prac.member.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@CrossOrigin(origins = "*")

public class HomeController {
    @GetMapping("/api")
    public String index(){
        return "index";
    }
}
