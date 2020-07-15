package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * 	Proyecto final del grupo 2 
 *
 */
@SpringBootApplication
public class ProyectoFinalTesteoCovid19Aplication implements CommandLineRunner{

/**
 * Creamos la variable del tipo servicio usuario, contiene eliminar modificar guardar etc.
 */
@Autowired
 IUsuarioService usuarioService;
 
/**
 * Creamos la variable de tipo usuario 
 */
 @Autowired
 Usuario usuario;
 
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalTesteoCovid19Aplication.class, args);
	}
	
	/**
	 * Clase principal run se ejecutan las sentencias siempre que ejecutemos el proyecto, es de la implementacion comanLineRunner
	 */
	@Override
	public void run(String... args) throws Exception {
		
		/**
		 * Inicializacion de las variables del objeto usuario,permitira guardar un usuario directamente en la BD, la usaremos para el usuario administrador
		 */
		/*usuario.setApellidoReal("Apellido");
		usuario.setNombreReal("Nombre");
		usuario.setNombreUsuario("admin");
		usuario.setTipoUsuario("BD");
		usuario.setPassword("12345678");
		/**
		 * Guardamos el usuario
		 */
		/*usuarioService.guardar(usuario);
		*/
	}
}
