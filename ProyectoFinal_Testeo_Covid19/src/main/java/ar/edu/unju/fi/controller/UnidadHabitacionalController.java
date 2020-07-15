package ar.edu.unju.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.service.IUnidadHabitacionalService;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * Clase controladora de la unidad habitacional, permite el alta unicamente.
 *
 */
@Controller
public class UnidadHabitacionalController {

	/**
	 * Variable de IUnidadHabitacional
	 */
	@Autowired
	private IUnidadHabitacionalService iunidadService;
	
	/**
	 * Variable de IBarrioService
	 */
	@Autowired
	private IBarrioService barrioService;
	
	/**
	 * Este método envía a la vista, por medio del modelo, un objeto de tipo
	 * UnidadHabitacional para ser llenado con los datos del usuario.
	 * También envía a la vista la lista de Unidades Habitacionales ya registradas
	 * en la base de datos y la lista de Barrios.
	 * @param model
	 * @return a la vista de registrarUnidad.
	 */
	@RequestMapping("/registroUnidadHabitacional")
	public String getform(Model model) {
		model.addAttribute("unidadformulario", new UnidadHabitacional());
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		model.addAttribute("listaUnidad", iunidadService.listarUnidad());
		return "registrarUnidad";
	}
	
	/**
	 * Este método recibe por medio del modelo, el objeto de tipo UnidadHabitacional
	 * que contiene los datos ingresados por el usuario y los guarda en la variable unidad.
	 * Comprueba que este no tenga errores para guardarlo en la base de datos. Si tiene errores
	 * lo envía nuevamente a la vista. También envía la lista de unidades habitacionales
	 * guardadas en la base de datos.
	 * @param unidad
	 * @param result
	 * @param model
	 * @return a la vista registrarUnidad.
	 */
	@PostMapping("/agregarUnidad")
	public String crearUnidad(@Valid @ModelAttribute("unidadformulario") UnidadHabitacional unidad, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("unidadformulario", unidad);
			model.addAttribute("listaUnidad", iunidadService.listarUnidad());
		} else {
			try {
				iunidadService.guardar(unidad);
				model.addAttribute("unidadformulario", new UnidadHabitacional());
				model.addAttribute("listaUnidad", iunidadService.listarUnidad());
			} catch (Exception e) {
				model.addAttribute("formUnidadErrorMessage", e.getMessage());
				model.addAttribute("unidadformulario", unidad);
				model.addAttribute("listaUnidad", iunidadService.listarUnidad());
			}
		}
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		return "registrarUnidad";
	}
}
