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
 * Controlador de las consultas. Todos los requerimientos que usara el usuario consultor
 *
 */
@Controller
public class ConsultasController {
  //Servicios de personas testeadas
	@Autowired	
	 IPersonaTesteadaService personaTesteadaService;
// Servicio de barrrios
	@Autowired
	IBarrioService barrioService;
	
	//objeto auxiliar de consulta, nos servira para las estadisticas.
	public ObjetoConsulta objetoCons = new ObjetoConsulta();
		
	
	/**
	 * Controlador para la consulta por dni lista todos las personas y presenta un pequeño formulario de filtrado...
	 * @return vista de consultaDNI
	 */
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
	/**
	 * Controlador POSTMAPPING una ver llenado el pequeño formulario de consulta por dni este filtrara los datos. 
	 * @param documentoConsu   variable que tomara el dato input del dni
	 * @return misma vista, con datos filtradoos
	 */
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
	
	
	
	/**
	 * Controlador para la consulta por apellido lista todos las personas y presenta un pequeño formulario de filtrado...
	 * @return vista de consultaApellido
	 */
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
	/**
	 * POSMAPPING se activa al solicitar la busqueda de una personaTesteada por apellido 
	 * @param apellidoConsu es el parametro que recibe el input del usuario, un apellido 
	 * @return consultaApellido con los datos filtrados
	 */
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
	
	
	/**
	 * Controlador para la consulta por BARRIO en este caso lista todos las personas y presenta un pequeño formulario de filtrado,
	 * donde solicita que seleccionen un barrio y 2 fechas-horas
	 * @return vista de consultaApellido
	 */
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
	
	/**
	 * Controlador POSTMAPPING , este se activa al solicitar la busqueda, busca por el barrio, lo ordena por unidad habitacional,
	 * entre 2 fechas solicitadas 
	 * @param objetoConsulta objeto que recibio las 2 fechas, y el barrio seleccionado
	 * @param model
	 * @return consulta, con los datos filtrados
	 */
	@PostMapping("/consulta")
	public String getconsPos(@ModelAttribute("objetoConsulta") ObjetoConsulta objetoConsulta, Model model)
	{
		// adaptamos la cadena para su convercion
		String fecha1Cadena = objetoConsulta.getTime1()+":01";
		String fecha2Cadena = objetoConsulta.getTime2()+":01";
		
		// convertimos las cadenas en objeto LOCALDATETIME
		LocalDateTime fechaInicio=LocalDateTime.parse(fecha1Cadena);
		LocalDateTime fechaFin=LocalDateTime.parse(fecha2Cadena);
		
		// enviamos la lista filtrada al modelo
		model.addAttribute("listaPersonas", personaTesteadaService.listarBarrioFechas(objetoConsulta.getBarrio(),fechaInicio,fechaFin));
		// obtenemos las estadisticas mediante el objeto consulta
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
