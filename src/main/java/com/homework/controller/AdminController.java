package com.homework.controller;

import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String getALLPersons(Model model) {
        var persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "admin";
    }
}
