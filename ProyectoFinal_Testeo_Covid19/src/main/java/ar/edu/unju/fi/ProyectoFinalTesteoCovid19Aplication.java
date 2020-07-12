package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.testeos.model.Usuario;

@SpringBootApplication
public class ProyectoFinalTesteoCovid19Aplication implements CommandLineRunner{
 @Autowired
 IUsuarioService usuarioService;
 
 @Autowired
 Usuario usuario;
 
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalTesteoCovid19Aplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*usuario.setApellidoReal("Apellido");
		usuario.setNombreReal("Nombre");
		usuario.setNombreUsuario("admin");
		usuario.setTipoUsuario("BD");
		usuario.setPassword("12345678");
		usuarioService.guardar(usuario);*/
		
	}
}
