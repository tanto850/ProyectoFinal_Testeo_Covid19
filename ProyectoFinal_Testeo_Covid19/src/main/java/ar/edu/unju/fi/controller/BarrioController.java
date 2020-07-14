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

@Controller
public class BarrioController {

	@Autowired
	private IBarrioService ibarrioService;
	
	@Autowired
	private Barrio unBarrio;

	@RequestMapping("/registroBarrio")
	public String getIndex(Model model) {
		model.addAttribute("barrioformulario", new Barrio());
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
		return "registroBarrio";
	}
	
	@PostMapping("/agregarBarrio")
	public String crearUsuario(@Valid @ModelAttribute("barrioformulario") Barrio barrio, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("barrioformulario", barrio);
			// model.addAttribute("formTab", "active");
		} else {
			try {
				ibarrioService.guardar(barrio);
				model.addAttribute("barrioformulario", new Barrio());
				model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
				// model.addAttribute("lisTab", "active");
			} catch (Exception e) {
				model.addAttribute("formBarrioErrorMessage", e.getMessage());
				model.addAttribute("barrioformulario", barrio);
				model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
				// model.addAttribute("formTab", "active");
			}
		}
		return "registroBarrio";
	}
	
	@GetMapping("/editarBarrio/{id}")
	public String editarBarrio(Model model, @PathVariable(name="id") Long id) throws Exception {		
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
	
	@PostMapping("/editarBarrio")
	public String postEditarBarrio(@Valid @ModelAttribute("barrioformulario") Barrio barrio, BindingResult result, ModelMap model) {
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
	
	/*
	 * Metodo usado para eliminar un registro de barrio.
	 */
	@GetMapping("/eliminarBarrio/{id}")
	public String eliminarBarrio(Model model, @PathVariable(name="id") long id) {
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
