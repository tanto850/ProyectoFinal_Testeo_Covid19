package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
public class LogueoController {
	
	
	
	

	@GetMapping("/login")
	public String logCuenta() {
		return "inicio";
	}
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping("/login")
	public String getIndex(Model model) {
		
		model.addAttribute("usuariologueo", new Usuario());
		
		return "inicio";
	}
	

	@GetMapping("/registroUsuario")
	public String loginExitoso(Model model) {
		
		return "registroUsuario";
	}
	
	@GetMapping("/formularioPersona")
	public String formulario(Model model) {
		
		return "formularioPersona";
	}
	
	@GetMapping("/consulta")
	public String consulta(Model model) {
		
		return "consulta";
	}
	
	@PostMapping("/registraUsuario")
		public String registroUsuario(@ModelAttribute("usuariologueo") Usuario unUsuario,Model model) {
		
		usuarioService.guardar(unUsuario);
		
		return "registroUsuario";
		
	}
				

}
