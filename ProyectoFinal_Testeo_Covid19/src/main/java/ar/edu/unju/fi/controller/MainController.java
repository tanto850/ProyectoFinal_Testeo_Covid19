package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.service.IUnidadHabitacionalService;

@Controller
public class MainController {
	@Autowired
	IBarrioService barrioService;
	
	@Autowired
	IPersonaTesteadaService personaTesteadaService;
	
	
	@Autowired
	private IUnidadHabitacionalService iunidadService;
	

//@RequestMapping("inicio")
	//public String getInicio(Model model) {
		 //model.addAttribute("usuario", usuarioService.listarUsuario().getNombreUsuario());
//		return "registroUsuario";
//	}
	
	@RequestMapping("/")
	public String getCuenta(Model model) {
		return "cuenta";
	}

	/*@RequestMapping("/registroBarrio")
	public String getBarrio(Model model) {
		return "registroBarrio";
	}
	*/
	
	/*@RequestMapping("/usuarioBM")
	public String getusuarioBM(Model model) {
		return "usuarioBM";
	}*/

	@RequestMapping("/consulta")
	public String getcons(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		return "consulta";
}
	
	
	@RequestMapping("/seleccion")
	public String getconsss(Model model) {
		model.addAttribute("listaUnidad",iunidadService.listarUnidad());
		return "seleccionarUnidad";
}
	
	
	
	
}
