package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IUsuarioService;

@Controller
public class MainController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping("/index")
	public String getIndex(Model model) {
		model.addAttribute("usuario", usuarioService.mostrar().getNombreUsuario());
		return "inicio";
	}
	
	@RequestMapping("inicio")
	public String getInicio(Model model) {
		 model.addAttribute("usuario", usuarioService.mostrar().getNombreUsuario());
		return "inicio";
	}
	
	@RequestMapping("cuenta")
	public String getCuenta(Model model) {
		return "cuenta";
	}
	
	@RequestMapping("/formulario")
	public String getFormulario(Model model) {
		return "formularioPersona";
	}

}
