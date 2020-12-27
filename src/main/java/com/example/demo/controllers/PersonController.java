package com.example.demo.controllers;

import com.example.demo.domains.Person;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String home() {
        return "signup";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public ModelAndView createPerson(Person person) {
        ModelAndView model = new ModelAndView();
        personService.save(person);
        model.setViewName("signup");
        return model;
    }
}
