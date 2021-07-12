package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/another")
public class AnotherController {
    @GetMapping("/another")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        //http://localhost:8080/another/another?name=Artem
        System.out.println("::: " + name);
        return "another/another";
    }
}
