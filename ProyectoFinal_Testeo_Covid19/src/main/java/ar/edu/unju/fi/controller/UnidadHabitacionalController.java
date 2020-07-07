package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IBarrioService;

@Controller
public class UnidadHabitacionalController {

	@Autowired
	 IBarrioService barrioService;
	
	@RequestMapping("/registroUnidadHabitacional")
	public String getform(Model model) {
		model.addAttribute("listaBarrios", barrioService.listarBarrios());
		return "registrarUnidad";
}
}
