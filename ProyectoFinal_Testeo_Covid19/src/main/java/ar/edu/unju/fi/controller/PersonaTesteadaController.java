package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

@Controller
public class PersonaTesteadaController {
	
	@Autowired
	private IPersonaTesteadaService ipersonaTesteadaService;

	@RequestMapping("/registropersona")
	public String getIndex(Model model) {
		model.addAttribute("personaformulario", new PersonaTesteada());
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadas());
		return "formularioPersona";
	}
	
	@PostMapping("/guardarPersona")
	public String crearUsuario(@ModelAttribute("personaformulario") PersonaTesteada personaTesteada,BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("personaformulario", personaTesteada);
			model.addAttribute("formTab", "active");
		}else {
		//try {
			ipersonaTesteadaService.guardar(personaTesteada);
			model.addAttribute("personaformulario", new PersonaTesteada());
			model.addAttribute("lisTab", "active");
			model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadas());
		//} catch (Exception e) {
			
		//}
		}
		return "formularioPersona";
	}
	
	@GetMapping("/editarPersona/{id}")
	public String editarPersona(@PathVariable long id, Model model) {
		Optional<PersonaTesteada> personaTesteada = ipersonaTesteadaService.listarPersonaId(id);
		model.addAttribute("personaformulario", personaTesteada);
		return "redirect:/registropersona";
	}
	
	@GetMapping("/eliminarPersona/{id}")
	public String eliminarPersona(Model model, @PathVariable long id) {
		ipersonaTesteadaService.eliminar(id);
		return "redirect:/registropersona";
	}
	
}
