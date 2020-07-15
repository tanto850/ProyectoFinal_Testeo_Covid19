package ar.edu.unju.fi.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

//import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
public class LogueoController {
	
/*	@GetMapping("/formularioPersona")
	public String formulario(Model model) {	
		return "formularioPersona";
	}*/
	

	@GetMapping("/login")
	public String ingresar(Model model) {
		model.addAttribute("usuariologueo", new Usuario());	
		return "inicio";
	}	
	
	@GetMapping("/noautorizado")
	public String noAutorizado(Model model) {
		return "noAutorizado";
	}

}
