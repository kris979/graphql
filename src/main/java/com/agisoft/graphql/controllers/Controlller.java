package com.agisoft.graphql.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controlller {


    @GetMapping("/hello")
    public String hello() {
        log.info("Returning hello");
        return "<h1>Hello</h1>";
    }

    @GetMapping("/secured")
    public String secured() {
        log.info("Authenticated hello");
        return "<h1>Hello</h1>";
    }

}
