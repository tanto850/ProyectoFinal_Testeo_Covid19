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
		model.addAttribute("objetoConsulta", new ObjetoConsulta());
		return "consulta";
}
	@PostMapping("/consulta")
	public String getconsPos(@ModelAttribute("objetoConsulta") ObjetoConsulta objetoConsulta, Model model)
	{
		//lista tabla encontrados
		//System.out.println("BARRIIo" +  objetoConsulta.getBarrio() + objetoConsulta.getTime1());
		String fecha1Cadena = objetoConsulta.getTime1()+":01";
		String fecha2Cadena = objetoConsulta.getTime2()+":01";
		
		LocalDateTime fechaInicio=LocalDateTime.parse(fecha1Cadena);
		LocalDateTime fechaFin=LocalDateTime.parse(fecha2Cadena);
				
		model.addAttribute("listaPersonas", personaTesteadaService.listarBarrioFechas(objetoConsulta.getBarrio(),fechaInicio,fechaFin));
		//lista de seleccion de barrios
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
	return "consulta";	
	}
	
}
