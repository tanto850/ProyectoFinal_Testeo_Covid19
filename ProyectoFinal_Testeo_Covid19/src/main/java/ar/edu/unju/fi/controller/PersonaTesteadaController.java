package ar.edu.unju.fi.controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.PersonaTesteadaServiceImp;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

public class PersonaTesteadaController {
	
	private PersonaTesteadaServiceImp personaTesteadaService;

	@RequestMapping("/formulario")
	public String getIndex(Model model) {
		model.addAttribute("personaformulario", new PersonaTesteada());
		model.addAttribute("listaPersonaTesteada", personaTesteadaService.listarPersonasTesteadas());
		return "formularioPersona";
	}
	
	@PostMapping("/guardarPersona")
	public String crearUsuario(@ModelAttribute("usuarioformulario") PersonaTesteada personaTesteada, ModelMap model) {
		//try {
			personaTesteadaService.guardar(personaTesteada);
			model.addAttribute("personaformulario", new PersonaTesteada());
			//model.addAttribute("lisTab", "active");
		//} catch (Exception e) {
			
		//}
		return "formularioPersona";
	}
}
