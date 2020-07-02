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
			
			System.out.println("El usuario " + unUsuario.getApellidoReal() + "ha sido guardado.");
			iUsuario.save(unUsuario);
			
		}

		@Override
		 public void eliminar(long dni) {
			iUsuario.deleteById(dni);;
		}


		@Override
		public void modificar() {
			// TODO Auto-generated method stub
			//iUsuario.modificar();	
		}

		@Override
		public Iterable<Usuario> listarUsuario() {
			
			return iUsuario.findAll();
		}
}
