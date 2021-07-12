package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    @GetMapping("/")
    public String f(@RequestParam(value = "first") String first,
                         @RequestParam(value = "sign") String sign,
                         @RequestParam(value = "second") String second,
                         Model model) {
        try {
            int a = Integer.parseInt(first);
            int b = Integer.parseInt(second);

            System.out.println(sign);


            switch (sign) {
                case "plus":
                    model.addAttribute("result", Integer.toString(a + b));
                    break;
                case "minus":
                    model.addAttribute("result", Integer.toString(a - b));
                    break;
                case "multiply":
                    model.addAttribute("result", Integer.toString(a * b));
                    break;
                case "divide":
                    if (b != 0)
                        model.addAttribute("result", Integer.toString(a / b));
                    else
                        model.addAttribute("result", "Error: division by zero");
                    break;
                default:
                    model.addAttribute("result", "Error: wrong sign");
            }
        } catch (NumberFormatException ex){
            model.addAttribute("result", "Error: not a numbers");
        }



        return "calc/calc";
    }
}
