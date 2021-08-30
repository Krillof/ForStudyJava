package com.mimimetr.view;

import com.mimimetr.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Entering {
    @GetMapping("/login")
    public String entering(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register_post(@RequestParam(name="username") String username,
                                @RequestParam(name="password") String password){
        if (userService.TryAddUser(username, password)){
            return "redirect:/";
        } else {
            return "this_user_already_exists";
        }

    }
}
