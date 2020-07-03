package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
public class MainController {
	@Autowired
	private IUsuarioService iusuarioService;
	
	@RequestMapping("/registroUsuario")
	public String getIndex(Model model) {
		model.addAttribute("usuarioformulario", new Usuario());
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		return "registroUsuario";
	}
	
	@PostMapping("/registroUsuario")
	public String crearUsuario(@ModelAttribute("usuarioformulario") Usuario usuario, ModelMap model) {
		//try {
			iusuarioService.guardar(usuario);
			model.addAttribute("usuarioformulario", new Usuario());
			//model.addAttribute("lisTab", "active");
		//} catch (Exception e) {
			
		//}
		return "registroUsuario";
	}
	
	
	//@RequestMapping("inicio")
	//public String getInicio(Model model) {
		 //model.addAttribute("usuario", usuarioService.listarUsuario().getNombreUsuario());
//		return "registroUsuario";
//	}
	
	@RequestMapping("/")
	public String getCuenta(Model model) {
		return "cuenta";
	}
	
	@RequestMapping("/formulario")
	public String getFormulario(Model model) {
		return "formularioPersona";
	}

}
