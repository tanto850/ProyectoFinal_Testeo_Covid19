package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public String getIndex(Model model) {
		return "inicio";
	}
	
	@RequestMapping("inicio")
	public String getInicio(Model model) {
		return "inicio";
	}
	
	@RequestMapping("cuenta")
	public String getCuenta(Model model) {
		return "cuenta";
	}
	

}
