package com.controllers;

import com.entities.AbstractEntity;
import com.entities.Person;
import com.exceptions.NotFoundException;
import com.services.impl.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Handles requests to list all persons.
     */
    @GetMapping(value = "/list")
    public String list(Model model) {
        logger.info("Populating model with list...");
        List<Person> persons =  personService.findAll();
        persons.sort(Comparator.comparing(Person::getId));
        model.addAttribute("persons", persons);
        return "persons/list";
    }

    /**
     * Handles requests to show detail about one person.
     */
    @RequestMapping(value = "/{id:[\\d]*}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model) {
        Optional<Person> personOpt = personService.findById(id);
       if(personOpt.isPresent()) {
           model.addAttribute("person", personOpt.get());
       } else {
           throw new NotFoundException(Person.class, id);
       }
        return "persons/show";
    }

    // This was commented to move the implementation in the MissingRecordsHandler
   /* @ExceptionHandler
    public ModelAndView notFound(HttpServletRequest req, NotFoundException nfe) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("problem", "Malformed URL: " + req.getRequestURI() + "<br/>" + nfe.getMessage());
        mav.setViewName("error");
        return mav;
    }*/
}
