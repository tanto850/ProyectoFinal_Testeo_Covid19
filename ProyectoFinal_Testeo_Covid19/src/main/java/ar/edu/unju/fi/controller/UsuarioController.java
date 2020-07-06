package ar.edu.unju.fi.controller;

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

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iusuarioService;
	
	@Autowired
	private Usuario unUsuario;
	
	@RequestMapping("/registroUsuario")
	public String agregarUsuario(Model model) {
		model.addAttribute("usuarioformulario", new Usuario());
		//model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		return "registroUsuario";
	}
	
	@PostMapping("/registroUsuario")
	public String crearUsuario(@ModelAttribute("usuarioformulario") Usuario usuario, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			model.addAttribute("usuarioformulario", usuario);
			// model.addAttribute("formTab", "active");
		} else {
			try {
				iusuarioService.guardar(usuario);
				model.addAttribute("usuarioformulario", new Usuario());
				model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
				// model.addAttribute("lisTab", "active");
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("usuarioformulario", usuario);
				model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
				// model.addAttribute("formTab", "active");
			}
		}
		return "usuarioBM";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {		
		try {
			Usuario usuarioEncontrado = iusuarioService.encontrarUsuario(id);
			model.addAttribute("usuarioformulario", usuarioEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("usuarioformulario", unUsuario);
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());		
		model.addAttribute("formTab", "active");		
		return "registroUsuario";
	}
	
	@PostMapping("/editarUsuario")
	public String postEditarUsuario(@Valid @ModelAttribute("usuarioformulario") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioformulario", usuario);			
			//model.addAttribute("formTab", "active");
			model.addAttribute("editMode", "true");
		} else {
			try {
				iusuarioService.modificar(usuario);
				model.addAttribute("usuarioformulario", unUsuario);			
				//model.addAttribute("listTab", "active");
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("usuarioformulario", usuario);			
				//model.addAttribute("formTab", "active");
				model.addAttribute("listaUsuario", iusuarioService.listarUsuario());				
				model.addAttribute("editMode", "true");
			}
		}
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());		
		return "usuarioBM";
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			iusuarioService.eliminar(id);;
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "usuarioBM";
	}
	
	@GetMapping("/usuarioBM")
	public String listarUsuarios(Model model) {
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		return "usuarioBM";
	}
}
