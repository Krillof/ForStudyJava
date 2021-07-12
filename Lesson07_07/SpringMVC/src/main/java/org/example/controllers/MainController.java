package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {
    @GetMapping("/")
    public String sayHello(HttpServletRequest request,
                           Model model) {

        //http://localhost:8080/?name=Artem&age=18
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);


        model.addAttribute("message", name);

        return "main/main";
    }

    @GetMapping("/bye")
    public String sayBye(@RequestParam(value = "name", required = false) String name) {
        System.out.println(":::::: " + name);
        return "main/bye";
    }
}
