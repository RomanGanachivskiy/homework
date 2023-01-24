package com.homework.controller;

import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cabinet")
public class CabinetController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPersonCabinet(@PathVariable String id, Model model) {
        var personId = Long.valueOf(id);
        var person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        return "cabinet";
    }
}
