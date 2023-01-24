package com.homework.controller;

import com.homework.security.MyPersonDetails;
import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @RequestMapping(method = RequestMethod.GET)
    public String getPersonCabinet(Model model) {
               var auth = SecurityContextHolder.getContext().getAuthentication();
               var authUserName = ((MyPersonDetails) auth.getPrincipal()).getUsername();
               var person = personService.getPersonByEmail(authUserName);
        model.addAttribute("person", person);
        return "cabinet";
    }
}
