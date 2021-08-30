package com.mimimetr.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Entering {
    @GetMapping("/login")
    public String entering(){
        return "login";
    }
}
