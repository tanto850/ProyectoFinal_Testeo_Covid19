package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public RegistroTesteo registroTesteo;
	public PersonaTesteada unaPersonaTesteada;
	
	@GetMapping("/seleccion")
	public String getconsss(Model model) {
		model.addAttribute("testeoformulario", new RegistroTesteo());
		model.addAttribute("listaUnidad",iunidadService.listarUnidad());
		return "seleccionarUnidad";
	}
	
	/*
	 * 
	 */
	@PostMapping("/continuar")
	public String continuar(@ModelAttribute("testeoformulario") RegistroTesteo testeo ,Model model) {
		testeo.setFechaHora(LocalDateTime.now());
		itesteoService.guardar(testeo);
	    System.out.println(testeo.getId());
		//model.addAttribute("testeoformulario", registroTesteo);
		registroTesteo = testeo;
		model.addAttribute("personaformulario", new PersonaTesteada());
		//model.addAttribute("personaformulario", unaPersonaTesteada);
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
		model.addAttribute("formTab", "active");
		return "formularioPersona";
	}
		
	
	@RequestMapping("/registroPersona")
	public String getIndex(Model model, RegistroTesteo registroTesteo) {
		PersonaTesteada personaTesteada =  new PersonaTesteada();
		personaTesteada.setRegistroTesteo(registroTesteo);
		model.addAttribute("personaformulario", personaTesteada);
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
		model.addAttribute("formTab", "active");
		return "formularioPersona";
	}
	
	@PostMapping("/guardarPersona")
	public String crearUsuario(@Valid @ModelAttribute("personaformulario") PersonaTesteada personaTesteada,
			BindingResult result, ModelMap model) {
		if (result.hasErrors() || ipersonaTesteadaService.encontrarPersonaRegistro(personaTesteada)) {
			model.addAttribute("personaformulario", personaTesteada);
			model.addAttribute("formTab", "active");
		} else {
			try {
				personaTesteada.setRegistroTesteo(registroTesteo);
				ipersonaTesteadaService.guardar(personaTesteada);
				model.addAttribute("personaformulario", new PersonaTesteada());
				model.addAttribute("formTab", "active");
				// model.addAttribute("lisTab", "active");
				model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
			} catch (Exception e) {
				model.addAttribute("formPersonaErrorMessage",e.getMessage());
				model.addAttribute("personaformulario", personaTesteada);			
				model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));				
				model.addAttribute("editMode", "true");
			}
		}
		return "formularioPersona";
	}
	
}
