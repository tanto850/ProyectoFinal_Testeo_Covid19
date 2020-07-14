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

@Controller
public class UnidadHabitacionalController {

	@Autowired
	private IUnidadHabitacionalService iunidadService;
	@Autowired
	 IBarrioService barrioService;
	
	@RequestMapping("/registroUnidadHabitacional")
	public String getform(Model model) {
		model.addAttribute("unidadformulario", new UnidadHabitacional());
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		model.addAttribute("listaUnidad", iunidadService.listarUnidad());
		return "registrarUnidad";
	}
	
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
