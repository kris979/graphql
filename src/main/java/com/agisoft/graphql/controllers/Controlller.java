package com.agisoft.graphql.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlller {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Hello</h1>";
    }

}
