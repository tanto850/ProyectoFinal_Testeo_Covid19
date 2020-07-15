/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * Clase que va a implementar la interfaz IUsuarioService
 *  definimos como va a actuar los metodos creados en IusuarioService
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	/**
	 * Inyeccion de un objeto de la clase IUsuarioRepository para la conexion de la capa repository
	 */
	@Autowired
	public IUsuarioRepository iUsuario;
	
	private Logger log = Logger.getLogger("");
	
	
	/**
	 * Metodo que permite guardar un usuario en el gestor MySQL
	 * con la contraseña encriptada
	 */
		@Override
		public void guardar(Usuario unUsuario) {
			
			String pw = unUsuario.getPassword();
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
			//Se encripta la contraseña del Usuario
			unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
			log.info("El usuario "+ unUsuario.getApellidoReal()+" ha sido guardado.");;
			iUsuario.save(unUsuario);
			
		}
		
		
		/**
		 * Metodo que permite eliminar un usuario
		 */
		@Override
		 public void eliminar(long dni) {
		
			iUsuario.deleteById(dni);;
			log.info("El usuario ha sido eliminado.");
		}

		
		/**
		 * Metodo que permite guardar los datos modificados de un usuario
		 */
		@Override
		public Usuario modificar(Usuario unUsuario) throws Exception {
			// TODO Auto-generated method stub
			log.info("El usuario ha sido modificado.");
			return iUsuario.save(unUsuario);
		}
		
		/**
		 * Metodo que permite listar todos los usuarios del repositorio
		 */
		@Override
		public Iterable<Usuario> listarUsuario() {
			log.info("Listado de usuarios.");
			return iUsuario.findAll();
		}
		
		
		/**
		 * Metodo que permite buscar un usuario particular segun por su ID
		 */
		@Override
		public Usuario encontrarUsuario2(Long id) throws Exception {
			// TODO Auto-generated method stub
			return iUsuario.findById(id).orElseThrow(()-> new Exception("El usuario no existe."));
		}
			
		/**
		 * Metodo que permite buscar un usuario particular segun su nombre de usuario
		 */
		@Override
		public Usuario encontrarUsuario(String nombreUsuario) throws Exception {
			// TODO Auto-generated method stub
			log.info("Buscando usuario: " + nombreUsuario);
			return iUsuario.findByNombreUsuario(nombreUsuario).orElseThrow(()-> new Exception("El Usuario no Existe"));
		}
		
		
		public void mapearUsuario(Usuario hacia, Usuario desde) {
			hacia.setNombreUsuario(desde.getNombreUsuario());
			hacia.setNombreReal(desde.getNombreReal());
			hacia.setApellidoReal(desde.getApellidoReal());
			hacia.setTipoUsuario(desde.getTipoUsuario());
			//hacia.setPassword(desde.getPassword());
		}
		
		/**
		 * Metodo que permite saber si existe un usuario 
		 */
		@Override
		public boolean encontrarNombreUsuario(Usuario unUsuario) {
			Optional<Usuario> nameUser = iUsuario.findByNombreUsuario(unUsuario.getNombreUsuario()); 
			return nameUser.isPresent();
		}
	
}
