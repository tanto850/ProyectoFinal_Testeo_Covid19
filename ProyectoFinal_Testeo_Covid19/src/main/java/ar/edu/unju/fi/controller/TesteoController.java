package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.service.IRegistroTesteoService;
import ar.edu.unju.fi.service.IUnidadHabitacionalService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

@Controller
public class TesteoController {
	
	@Autowired
	private IRegistroTesteoService itesteoService;
	@Autowired
	private IUnidadHabitacionalService iunidadService;
	@Autowired
	private IPersonaTesteadaService ipersonaTesteadaService;
	private RegistroTesteo registroTesteo;
	private PersonaTesteada unaPersonaTesteada;
	
	@GetMapping("/seleccion")
	public String getconsss(Model model) {
		model.addAttribute("testeoformulario", new RegistroTesteo());
		model.addAttribute("listaUnidad",iunidadService.listarUnidad());
		return "seleccionarUnidad";
	}
	
	
	@PostMapping("/continuar")
	public String continuar(@ModelAttribute("testeoformulario") RegistroTesteo testeo ,Model model) {
		testeo.setFechaHora(LocalDateTime.now());
		itesteoService.guardar(testeo);
		registroTesteo = itesteoService.encontrarRegistroTesteo(testeo.getFechaHora());
		//model.addAttribute("testeoformulario", registroTesteo);
		model.addAttribute("personaformulario", new PersonaTesteada());
		//model.addAttribute("personaformulario", unaPersonaTesteada);
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadas());
		model.addAttribute("listTab", "active");
		return "formularioPersona";
	}
	
	
}
