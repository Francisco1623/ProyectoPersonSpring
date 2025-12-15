package com.jacaranda.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Person;
import com.jacaranda.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@GetMapping({"/","persons"})
	public String getPersons(Model model) {
		try {
			model.addAttribute("listPerson",personService.getPersons());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "listPerson";
	}
	
	@GetMapping("/viewPerson")
	public String getPersonById(Model model,@ModelAttribute Person p, @RequestParam Optional<Integer> id,@RequestParam Optional<String> action) {
		try {
			p = personService.getPersonById(id.orElse(null));
			
			model.addAttribute("person", p);
			model.addAttribute("action", action.orElse(null));

		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "formPerson";
	}
	
	@GetMapping("/deletePerson")
	public String deletePersonGet(Model model,@ModelAttribute Person p, @RequestParam Optional<Integer> id,@RequestParam Optional<String> action) {
		try {
			
			p = personService.getPersonById(id.orElse(null));
			model.addAttribute("action", action.orElse(null));
			model.addAttribute("person", p);
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "formPerson";
	}
	
	@PostMapping("/deletePerson")
	public String deletePersonPost(Model model,@ModelAttribute Person p) {
		try {
			
			personService.deletePerson(p);
			model.addAttribute("person", p);
			model.addAttribute("listPerson",personService.getPersons());

		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "listPerson";
	}
	
	@GetMapping("/editPerson")
	public String editPersonGet(Model model,@ModelAttribute Person p, @RequestParam Optional<Integer> id,@RequestParam Optional<String> action) {
		try {
			
			p = personService.getPersonById(id.orElse(null));
			model.addAttribute("action", action.orElse(null));
			model.addAttribute("person", p);
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "formPerson";
	}
	
	@PostMapping("/editPerson")
	public String editPersonPost(Model model,@Validated @ModelAttribute Person p,BindingResult b,@RequestParam Optional<String> action) {
		try {
			if(b.hasErrors()) {
				model.addAttribute("action", action.orElse(null));

				return "formPerson";
			}
			personService.editPerson(p);
			model.addAttribute("person", p);
			model.addAttribute("listPerson",personService.getPersons());

		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "listPerson";
	}
	
	@GetMapping("/addPerson")
	public String addPersonGet(Model model,@RequestParam Optional<String> action) {
		try {
			
			model.addAttribute("action", action.orElse(null));
			model.addAttribute("person", new Person());
		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());

		}
		return "formPerson";
	}
	
	@PostMapping("/addPerson")
	public String addPersonPost(Model model,@Validated @ModelAttribute Person p,BindingResult b,@RequestParam Optional<String> action) {
		try {
			if(b.hasErrors()) {
				model.addAttribute("action", action.orElse(null));

				return "formPerson";
			}
			personService.addPerson(p);
			model.addAttribute("person", p);
			model.addAttribute("listPerson",personService.getPersons());

		} catch (Exception e) {
			model.addAttribute("error",e.getMessage());
			model.addAttribute("action", action.orElse(null));

			return "formPerson";

		}
		return "listPerson";
	}
	
	
	
	
	
	
}
