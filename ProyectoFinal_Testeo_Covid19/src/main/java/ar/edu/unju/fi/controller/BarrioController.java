package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.IBarrioService;
import ar.edu.unju.fi.testeos.model.Barrio;

@Controller
public class BarrioController {

	@Autowired
	private IBarrioService ibarrioService;

	@RequestMapping("/registrobarrio")
	public String getIndex(Model model) {
		model.addAttribute("barrioformulario", new Barrio());
		model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
		return "registroBarrio";
	}
	
	@PostMapping("/guardarBarrio")
	public String crearUsuario(@ModelAttribute("usuarioformulario") Barrio barrio,BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("barrioformulario", barrio);
			//model.addAttribute("formTab", "active");
		}else {
		//try {
			ibarrioService.guardar(barrio);
			model.addAttribute("barrioformulario", new Barrio());
			model.addAttribute("listaBarrio", ibarrioService.listarBarrios());
			//model.addAttribute("lisTab", "active");
		//} catch (Exception e) {
			
		//}
		}
		return "registroBarrio";
	}
}
