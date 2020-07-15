package ar.edu.unju.fi.controller;

//import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.testeos.model.Barrio;
/**
 * Clase controladora del barrio, permite alta baja modificacion y tambien podemos ver la tabla
 *
 */
@Controller
public class BarrioController {

	/**
	 * Variable de IBarrioService.
	 */
	@Autowired
	private IBarrioService ibarrioService;
	
	/**
	 * Variable de la clase Barrio.
	 */
	@Autowired
	private Barrio unBarrio;
	
	/**
	 * Este método envía a la vista, por medio del modelo, un objeto de tipo Barrio
	 * para ser llenado por el usuario, también se envía la lista de barrios.
	 * @param model
	 * @return retorna a la vista de RegistroBarrio.
	 */
	@RequestMapping("/registroBarrio")
	public String getIndex(Model model) {
		model.addAttribute("barrioformulario", new Barrio());
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
		model.addAttribute("bandera", false);
		return "registroBarrio";
	}
	
	/**
	 * Este método recibe de la vista un objeto de tipo Barrio con todos los datos llenados por el usuario
	 * para hacer el registro de un barrio, si este barrio ya se encuentra registrado el método no guarda
	 * el barrio y lo envía nuevamente a la vista, si este no tiene errores lo guarda en la base de datos 
	 * asignandole un id único. También envía la lista de barrios registrados.
	 * @param barrio
	 * @param result
	 * @param model
	 * @return retorna a la vista de RegistroBarrio. 
	 */
	@PostMapping("/agregarBarrio")
	public String crearUsuario(@Valid @ModelAttribute("barrioformulario") Barrio barrio, BindingResult result, ModelMap model) {
		
		if (result.hasErrors() || ibarrioService.encontrarNombreBarrio(barrio)) {
			model.addAttribute("barrioformulario", barrio);
			// model.addAttribute("formTab", "active");
			model.addAttribute("bandera", true);
			model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
		} else {
			try {
				ibarrioService.guardar(barrio);
				model.addAttribute("barrioformulario", new Barrio());
				model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
				model.addAttribute("bandera", false);
				// model.addAttribute("lisTab", "active");
			} catch (Exception e) {
				model.addAttribute("formBarrioErrorMessage", e.getMessage());
				model.addAttribute("barrioformulario", barrio);
				model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
				model.addAttribute("bandera", false);
				// model.addAttribute("formTab", "active");
			}
		}
		return "registroBarrio";
	}
	
	/**
	 * Este método recibe el id del barrio a editar, el cual es buscado en la base de datos y guardado
	 * en una variable, que por medio del modelo se envía a la vista para ser editado.
	 * @param model
	 * @param id
	 * @return retorna a la vista de RegistroBarrio.
	 */
	@GetMapping("/editarBarrio/{id}")
	public String editarBarrio(Model model, @PathVariable(name="id") Long id) throws Exception {
		model.addAttribute("bandera", false);
		try {
			Barrio barrioEncontrado = ibarrioService.encontrarBarrio(id);
			model.addAttribute("barrioformulario", barrioEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formBarrioErrorMessage",e.getMessage());
			model.addAttribute("barrioformulario", unBarrio);
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());		
		model.addAttribute("formTab", "active");		
		return "registroBarrio";
	}
	
	/**
	 * Este método recibe de la vista un objeto de tipo Barrio con todos los datos actualizados por el usuario,
	 * si este formulario no tiene errores lo guarda en la base de datos 
	 * con el id ya asignado en el guardado. También envía la lista de barrios registrados.
	 * @param barrio 
	 * @param result
	 * @param model 
	 * @return retorna a la vista Registro Barrio.
	 */
	@PostMapping("/editarBarrio")
	public String postEditarBarrio(@Valid @ModelAttribute("barrioformulario") Barrio barrio, BindingResult result, ModelMap model) {
		model.addAttribute("bandera", false);
		if(result.hasErrors()) {
			model.addAttribute("barrioformulario", barrio);
			model.addAttribute("editMode", "true");
		} else {
			try {
				ibarrioService.modificar(barrio);
				model.addAttribute("barrioformulario", unBarrio);			
				//model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formBarrioErrorMessage",e.getMessage());
				model.addAttribute("barrioformulario", barrio);			
				//model.addAttribute("formTab", "active");
				model.addAttribute("listaBarrio", ibarrioService.listarBarrios());				
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());		
		return "registroBarrio";
	}
	
	/**
	 * 
	 * Metodo usado para eliminar un registro de barrio.
	 * @param id del barrio
	 * @return redirecciona la pagina de registroBarrio
	 */
	@GetMapping("/eliminarBarrio/{id}")
	public String eliminarBarrio(Model model, @PathVariable(name="id") long id) {
		model.addAttribute("bandera", false);
		try {
			ibarrioService.eliminar(id);
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
		return "redirect:/registroBarrio";
	}
	
}
