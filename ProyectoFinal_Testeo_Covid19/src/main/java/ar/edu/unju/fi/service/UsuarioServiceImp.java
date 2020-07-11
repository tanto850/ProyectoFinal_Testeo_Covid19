/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
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

		@Override
		public void guardar(Usuario unUsuario) {
			
			System.out.println("El usuario " + unUsuario.getApellidoReal() + " ha sido guardado.");
			iUsuario.save(unUsuario);
			
		}

		@Override
		 public void eliminar(long dni) {
		
			iUsuario.deleteById(dni);;
			System.out.println("El usuario fue eliminado.");
		}


		@Override
		public Usuario modificar(Usuario unUsuario) throws Exception {
			// TODO Auto-generated method stub
			//Usuario usuarioGuardar = encontrarUsuario(unUsuario.getId());
			System.out.println(unUsuario);
			//mapearUsuario(unUsuario, usuarioGuardar);		
			//return iUsuario.save(usuarioGuardar);
			return iUsuario.save(unUsuario);
		}

		@Override
		public Iterable<Usuario> listarUsuario() {
			
			return iUsuario.findAll();
		}
		
		/*public void mapearUsuario(Usuario hacia, Usuario desde) {
			hacia.setNombreUsuario(desde.getNombreUsuario());
			hacia.setNombreReal(desde.getNombreReal());
			hacia.setApellidoReal(desde.getApellidoReal());
			hacia.setTipoUsuario(desde.getTipoUsuario());
			//hacia.setPassword(desde.getPassword());
		}*/

		@Override
		public Usuario encontrarUsuario(Long id) throws Exception {
			// TODO Auto-generated method stub
			return iUsuario.findById(id).orElseThrow(()-> new Exception("El usuario no existe."));
		}
		
	
}
