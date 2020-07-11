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
	
	
	/**
	 * Muestra la pagina login ante la peticion /
	 * @return la pagina de login
	 */
	@GetMapping("/")
	public String logIn() {
		return "inicio";
	}
	
	/**
	 * Muestra la pagina login ante la peticion /login
	 * @return la pagina de login
	 */
	@PostMapping("/login")
	public String login() {
		return "inicio";
	}
	
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
	
	@PostMapping("/registraUsuario")
		public String registroUsuario(@ModelAttribute("usuariologueo") Usuario unUsuario,Model model) {
		
		usuarioService.guardar(unUsuario);
		
		return "registroUsuario";
		
	}
				

}
