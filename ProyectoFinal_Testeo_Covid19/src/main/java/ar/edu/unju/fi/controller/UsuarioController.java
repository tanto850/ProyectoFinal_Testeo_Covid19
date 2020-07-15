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

/**
 * Clase controladora del usuario, permite alta baja modificacion.
 *
 */
@Controller
public class UsuarioController {
	
	/**
	 * Variable de IUsuarioService
	 */
	@Autowired
	private IUsuarioService iusuarioService;
	
	/**
	 * Variable de la clase Usuario
	 */
	@Autowired
	private Usuario unUsuario;
	
	/**
	 * Este método envía a la vista, por medio del modelo, un objeto de tipo Usuario
	 * para ser llenado por el usuario.
	 * @param model
	 * @return a la vista registroUsuario.
	 */
	@RequestMapping("/registroUsuario")
	public String agregarUsuario(Model model) {
		model.addAttribute("usuarioformulario", new Usuario());
		//model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		model.addAttribute("bandera", false);
		return "registroUsuario";
	}
	
	/**
	 * Este método recibe por medio del modelo, un objeto de tipo Usuario que contiene 
	 * todos los datos llenados por el usuario y los guarda en la variable usuario.
	 * Comprueba que el nombre del usuario no esté registrado, si está registrado lo devuelve
	 * a la vista, sino lo guarda en la base de datos. Envía la lista de usuarios registrados.
	 * @param usuario
	 * @param result
	 * @param model
	 * @return la vista usuarioBM.
	 */
	@PostMapping("/agregarUsuario")
	public String crearUsuario(@Valid @ModelAttribute("usuarioformulario") Usuario usuario, BindingResult result, ModelMap model) {
		
		if (result.hasErrors() || iusuarioService.encontrarNombreUsuario(usuario)) {
			model.addAttribute("usuarioformulario", usuario);
			// model.addAttribute("formTab", "active");
			model.addAttribute("bandera", true);
			return "registroUsuario";
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
			return "usuarioBM";
		}
	}
	
	/**
	 * Este método recibe como parametro el id del usuario que se desea editar,
	 * el cual es buscado y guardado en la variable usuarioEncontrado. 
	 * Por medio del modelo, se envía un objeto con los datos de usuarioEncontrado
	 * y se lo envía a la vista.
	 * @param model
	 * @param id
	 * @return la vista registroUsuario.
	 * @throws Exception
	 */
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {		
		try {
			Usuario usuarioEncontrado = iusuarioService.encontrarUsuario2(id);
			model.addAttribute("usuarioformulario", usuarioEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("usuarioformulario", unUsuario);
			model.addAttribute("editMode", "false");
		}				
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());				
		return "registroUsuario";
	}
	
	/**
	 * Este método recibe el objeto que fueron actualizados por el usuario. Si no 
	 * contiene errores lo guarda en la base de datos con el id asignado en el guardado.
	 * También envía la lista de usuarios registrados.
	 * @param usuario
	 * @param result
	 * @param model
	 * @return a la vista usuarioBM.
	 */
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
		return "/usuarioBM";
	}
	
	/**
	 * Este método recibe como parametro el id del usuario que se desea borrar.
	 * Llama al repositorio y elimina al usuario por su id. También envía la
	 * lista de usuarios registrados.
	 * @param model
	 * @param id del usuario a borrar.
	 * @return a la vista usuarioBM.
	 */
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name="id") Long id) {
		try {
			iusuarioService.eliminar(id);
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		return "redirect:/usuarioBM";
	}
	
	/**
	 * Método que permite ingresar a la lista de usuarios registrados.
	 * @return a la vista usuarioBM.
	 */
	@GetMapping("/usuarioBM")
	public String listarUsuarios(Model model) {
		model.addAttribute("listaUsuario", iusuarioService.listarUsuario());
		return "usuarioBM";
	}
	
	/**
	 * Metodo que retorna la vista que muestra una alerta, para cuando los usuarios deseen 
	 * acceder a páginas que no tienen permitido.
	 * @return a la vista no Autorizado.
	 */
	@RequestMapping("/noAutorizado")
	public String sinPermisos() {
		return "noAutorizado";
	}
}



