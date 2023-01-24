package com.homework.controller;

import com.homework.dto.PersonDTO;
import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "registration";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute PersonDTO personDTO, Model model) {
        var person = personService.savePerson(personDTO);
        return "redirect:/cabinet/" + person.getId();
    }
}
