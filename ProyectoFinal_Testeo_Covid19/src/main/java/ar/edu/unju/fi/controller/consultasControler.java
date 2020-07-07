package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaTesteadaService;

/**
 * @author Aucachi Fabian
 * 
 * Controlador de las consultas. todas
 *
 */
@Controller
public class consultasControler {

	@Autowired	
	 IPersonaTesteadaService personaTesteadaService;

	@Autowired
	 IBarrioService barrioService;
	
	@RequestMapping("/consultaBarrio")
	public String getform(Model model) {
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		return "consultaBarrio";
}
	
	@PostMapping("consultarBarrio")
	public String consulta(Model model)
	{
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		model.addAttribute("listaBarrios", barrioService.listarBarrios());	
		return "consultarBarrio";
		
	}
	
	
	
	@RequestMapping("/consultaDNI")
	public String getConsultadni(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		return "consultaDNI";
}
	
	@PostMapping("/consultaDNI")
	public String getconsultadni2(@RequestParam( value = "documentoConsu") Long documentoConsu, Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonaDocumento(documentoConsu.toString()));
			return "consultaDNI";
}
	
	
	
	
	@RequestMapping("/consultaApellido")
	public String getform3(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		return "consultaApellido";
}
	
	@PostMapping("/consultaApellido")
	public String getconsulta(@RequestParam( value = "apellidoConsu" ) String apellidoConsu, Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonaApellido(apellidoConsu));
		return "consultaApellido";
}	

}
