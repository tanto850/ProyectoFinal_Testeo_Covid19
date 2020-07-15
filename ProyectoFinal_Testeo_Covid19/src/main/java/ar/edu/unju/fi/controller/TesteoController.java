package ar.edu.unju.fi.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IPersonaTesteadaService;
import ar.edu.unju.fi.service.IRegistroTesteoService;
import ar.edu.unju.fi.service.IUnidadHabitacionalService;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * Clase controladora del registroTesteo y registroPersonas...
 *
 */
@Controller
public class TesteoController {
	
	@Autowired
	private IRegistroTesteoService itesteoService;
	@Autowired
	private IUnidadHabitacionalService iunidadService;
	@Autowired
	private IPersonaTesteadaService ipersonaTesteadaService;
	
	public RegistroTesteo registroTesteo;
	
	public PersonaTesteada unaPersonaTesteada;
	
	/**
	 * peticion que nos permitira seleccionar una unidad, o crear una.
	 * @param model
	 * @return a la vista SeleccionarUnidad.
	 */
	@GetMapping("/seleccion")
	public String getconsss(Model model) {
		model.addAttribute("testeoformulario", new RegistroTesteo());
		model.addAttribute("listaUnidad",iunidadService.listarUnidad());
		return "seleccionarUnidad";
	}
	
	/**
	* En caso de que seleccionemos una unidad, continuamos con el dato de la unidad a registrar personas tambien se registra el testeo
	* con su fecha y hora correspondiente, por mas que nos saltiemos y no registremos ninguna persona testeada
	* Aquí se guarda el Registro Testeo, asignando a su atributo FechaHora, el horario actual.
	* @param testeo
	* @param model
	* @return a la vista formularioPersona.
	*/
	@PostMapping("/continuar")
	public String continuar(@ModelAttribute("testeoformulario") RegistroTesteo testeo ,Model model) {
		testeo.setFechaHora(LocalDateTime.now());
		itesteoService.guardar(testeo);
		registroTesteo = testeo;
		model.addAttribute("personaformulario", new PersonaTesteada());
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
		model.addAttribute("formTab", "active");
		return "formularioPersona";
	}
	
	/**
	 * En este método se envía un formulario vacío de tipo PersonaTesteada para que sea llenado por el 
	 * usuario Registrador. También se envía la lista de personas testeadas en el registro correspondiente.
	 * @param model
	 * @param registroTesteo
	 * @return a la vista formularioPersona.
	 */
	@RequestMapping("/registroPersona")
	public String getIndex(Model model, RegistroTesteo registroTesteo) {
		PersonaTesteada personaTesteada =  new PersonaTesteada();
		personaTesteada.setRegistroTesteo(registroTesteo);
		model.addAttribute("personaformulario", personaTesteada);
		model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
		model.addAttribute("formTab", "active");
		return "formularioPersona";
	}
	
	/**
	 * En este método se recibe el objeto personaformulario, que contiene todos los datos ingresados
	 * por el usuario, Verifica si contiene errores, si es así es enviado nuevamente a la vista
	 * para que el usuario los corrija e ingresa nuevamente en este método
	 * donde se le asigna el id del registro correspondiente y es guardada en la base de datos con un id 
	 * único.
	 * @param personaTesteada
	 * @param result
	 * @param model
	 * @return a la vista formularioPersona.
	 */
	@PostMapping("/guardarPersona")
	public String crearUsuario(@Valid @ModelAttribute("personaformulario") PersonaTesteada personaTesteada,
			BindingResult result, ModelMap model) {
		if (result.hasErrors() || !ipersonaTesteadaService.encontrarPersonaRegistro(personaTesteada)) {
			model.addAttribute("personaformulario", personaTesteada);
			//model.addAttribute("formTab", "active");
		} else {
			try {
				personaTesteada.setRegistroTesteo(registroTesteo);
				ipersonaTesteadaService.guardar(personaTesteada);
				model.addAttribute("personaformulario", new PersonaTesteada());
				model.addAttribute("formTab", "active");
				// model.addAttribute("lisTab", "active");
				model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));
			} catch (Exception e) {
				model.addAttribute("formPersonaErrorMessage",e.getMessage());
				model.addAttribute("personaformulario", personaTesteada);			
				model.addAttribute("listaPersonaTesteada", ipersonaTesteadaService.listarPersonasTesteadasRegistro(registroTesteo));				
				model.addAttribute("editMode", "true");
			}
		}
		return "formularioPersona";
	}
	
}
