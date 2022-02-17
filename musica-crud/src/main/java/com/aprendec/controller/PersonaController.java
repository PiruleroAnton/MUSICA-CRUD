package com.aprendec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aprendec.model.Persona;
import com.aprendec.model.musico_pruebas;
import com.aprendec.service.PersonaService;
import com.aprendec.service.MusicoService; 

@Controller
public class PersonaController {

	@Autowired(required=true)
	private PersonaService personaService;
	
	@Autowired(required=true)
	private MusicoService musicoService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personaService.getAll());
		return "index";
	}
	
	

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("persona", personaService.get(id));
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		personaService.save(persona);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		personaService.delete(id);

		return "redirect:/";
	}
	
	//mapeos para la nueva pagina de musicos
	@RequestMapping("/index2")
	public String index2(Model model) {
		model.addAttribute("list", musicoService.getAll());
		return "index2";
	}
	@GetMapping("/save2/{id}")
	public String showSave2(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("musico", musicoService.get(id));
		} else {
			model.addAttribute("musico", new musico_pruebas());
		}
		return "save2";
	}
	@PostMapping("/save2")
	public String save2(musico_pruebas musico, Model model) {
		musicoService.save(musico);
		return "redirect:/index2";
	}
	@GetMapping("/delete2/{id}")
	public String delete2(@PathVariable Long id, Model model) {
		musicoService.delete(id);

		return "redirect:/index2";
	}

}