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
	public IUsuarioRepository iusuario;

		@Override
		public void guardar(Usuario unUsuario) {
			
			System.out.println("El usuario " + unUsuario.getApellidoReal() + "ha sido guardado.");
			iusuario.save(unUsuario);
			
		}

		@Override
		 public void eliminar(long id) {
			iusuario.deleteById(id);;
		}


		@Override
		public void modificar() {
			// TODO Auto-generated method stub
			//iusuario.modificar();	
		}

		@Override
		public Usuario mostrar() {
			// TODO Auto-generated method stub
			   //Usuario usuario= iusuario.mostrar();
				return null;
		}
}
