package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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

	
	@RequestMapping("/consultaBarrio")
	public String getform(Model model) {
		//model.addAttribute("usuario",usuarioService.Mostrar().getNombre());
		return "consultaBarrio";
}
	
	@RequestMapping("/consultaDNI")
	public String getform2(Model model) {
		//model.addAttribute("usuario",usuarioService.Mostrar().getNombre());
		return "consultaDNI";
}
	
	@RequestMapping("/consultaApellido")
	public String getform3(Model model) {
		//model.addAttribute("usuario",usuarioService.Mostrar().getNombre());
		return "consultaApellido";
}
	
	
}
