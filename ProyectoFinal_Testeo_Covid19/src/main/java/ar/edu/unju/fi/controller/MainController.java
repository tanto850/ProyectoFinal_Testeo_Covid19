package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.ObjetoConsulta;
//import ar.edu.unju.fi.service.IUnidadHabitacionalService;

@Controller
public class MainController {
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	IPersonaTesteadaService personaTesteadaService;
	
	
	//@Autowired
	//private IUnidadHabitacionalService iunidadService;
	

//@RequestMapping("inicio")
	//public String getInicio(Model model) {
		 //model.addAttribute("usuario", usuarioService.listarUsuario().getNombreUsuario());
//		return "registroUsuario";
//	}
	
	/*@RequestMapping("/")
	public String getCuenta(Model model) {
		return "cuenta";
	}*/

	/*@RequestMapping("/registroBarrio")
	public String getBarrio(Model model) {
		return "registroBarrio";
	}
	*/
	
	/*@RequestMapping("/usuarioBM")
	public String getusuarioBM(Model model) {
		return "usuarioBM";
	}*/
	

	
}
