package org.example.controllers;

import org.example.config.dao.PersonDAO;
import org.example.config.dao.UniversityDAO;
import org.example.config.models.Person;
import org.example.config.models.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/universities")//Добавь /universities в адресную строку, чтобы попасть сюда.
public class UniversitiesController {

    private final UniversityDAO universityDAO;

    @Autowired
    public UniversitiesController(UniversityDAO universityDAO) {
        this.universityDAO = universityDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("universities", universityDAO.index());
        return "universities/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("university", universityDAO.show(id));
        return "universities/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("university", new University());
        return "universities/new";
    }

    @PostMapping
    public String create(@ModelAttribute("university") University university){
        universityDAO.save(university);
        return "redirect:/universities";
    }
}
