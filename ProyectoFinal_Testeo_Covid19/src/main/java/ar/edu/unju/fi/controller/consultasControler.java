package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.testeos.model.ObjetoConsulta;

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
	
	public ObjetoConsulta objetoCons = new ObjetoConsulta();
		
	@RequestMapping("/consultaDNI")
	public String getConsultadni(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarPersonas());
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarPersonas());
		model.addAttribute("cantidadPositivo", positivos);
		model.addAttribute("cantidadNegativo", negativos);
		model.addAttribute("cantidadTotal", positivos + negativos);
		return "consultaDNI";
}
	
	@RequestMapping("/hola")
	public String getConsultadni2(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		return "u";
}
	
	@PostMapping("/consultaDNI")
	public String getconsultadni2(@RequestParam( value = "documentoConsu") Long documentoConsu, Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonaDocumento(documentoConsu.toString()));		
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarPersonaDocumento(documentoConsu.toString()));
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarPersonaDocumento(documentoConsu.toString()));
		model.addAttribute("cantidadPositivo", positivos);
		model.addAttribute("cantidadNegativo", negativos);
		model.addAttribute("cantidadTotal", positivos + negativos);
		return "consultaDNI";
}
	
	
	
	
	@RequestMapping("/consultaApellido")
	public String getform3(Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarPersonas());
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarPersonas());
		model.addAttribute("cantidadPositivo", positivos);
		model.addAttribute("cantidadNegativo", negativos);
		model.addAttribute("cantidadTotal", positivos + negativos);
		return "consultaApellido";
}
	
	@PostMapping("/consultaApellido")
	public String getconsulta(@RequestParam( value = "apellidoConsu" ) String apellidoConsu, Model model) {
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonaApellido(apellidoConsu));
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarPersonaApellido(apellidoConsu));
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarPersonaApellido(apellidoConsu));
		model.addAttribute("cantidadPositivo", positivos);
		model.addAttribute("cantidadNegativo", negativos);
		model.addAttribute("cantidadTotal", positivos + negativos);
		return "consultaApellido";
}	
	
	
	
	@RequestMapping("/consulta")
	public String getcons(Model model) {	
		model.addAttribute("listaPersonas", personaTesteadaService.listarPersonasTesteadas());
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarPersonas());
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarPersonas());
		model.addAttribute("cantidadPositivo", positivos);
		model.addAttribute("cantidadNegativo", negativos);
		model.addAttribute("cantidadTotal", positivos + negativos);
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
		int negativos = objetoCons.contarNegativos(personaTesteadaService.listarBarrioFechas(objetoConsulta.getBarrio(),fechaInicio,fechaFin));
		int positivos = objetoCons.contarPositivos(personaTesteadaService.listarBarrioFechas(objetoConsulta.getBarrio(),fechaInicio,fechaFin));		
		model.addAttribute("cantidadPositivo", negativos);
		model.addAttribute("cantidadNegativo", positivos);
		model.addAttribute("cantidadTotal", positivos+negativos);
		//lista de seleccion de barrios
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
	return "consulta";	
	}

/*	@RequestMapping("/consulta")
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
*/


}
