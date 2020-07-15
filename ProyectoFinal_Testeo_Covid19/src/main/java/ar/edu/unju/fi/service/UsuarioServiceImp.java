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
 * @author Aucachi Fabian
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	public IUsuarioRepository iUsuario;
	
	private Logger log = Logger.getLogger("");

		@Override
		public void guardar(Usuario unUsuario) {
			
			String pw = unUsuario.getPassword();
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
			//Se encripta la contraseña del Usuario
			unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
			log.info("El usuario "+ unUsuario.getApellidoReal()+" ha sido guardado.");;
			iUsuario.save(unUsuario);
			
		}

		@Override
		 public void eliminar(long dni) {
		
			iUsuario.deleteById(dni);;
			log.info("El usuario ha sido eliminado.");
		}


		@Override
		public Usuario modificar(Usuario unUsuario) throws Exception {
			// TODO Auto-generated method stub
			log.info("El usuario ha sido modificado.");
			return iUsuario.save(unUsuario);
		}

		@Override
		public Iterable<Usuario> listarUsuario() {
			log.info("Listado de usuarios.");
			return iUsuario.findAll();
		}

		@Override
		public Usuario encontrarUsuario2(Long id) throws Exception {
			// TODO Auto-generated method stub
			return iUsuario.findById(id).orElseThrow(()-> new Exception("El usuario no existe."));
		}
		
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

		@Override
		public boolean encontrarNombreUsuario(Usuario unUsuario) {
			Optional<Usuario> nameUser = iUsuario.findByNombreUsuario(unUsuario.getNombreUsuario()); 
			return nameUser.isPresent();
		}
	
}
