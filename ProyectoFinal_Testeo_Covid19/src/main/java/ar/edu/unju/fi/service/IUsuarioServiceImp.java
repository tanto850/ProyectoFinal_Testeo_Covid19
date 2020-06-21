/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUsuario;
import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class IUsuarioServiceImp implements IUsuarioService {
	@Autowired
	public IUsuario iusuario;

		@Override
		public void guardar() {
			// TODO Auto-generated method stub
			iusuario.guardar();
			
		}

		@Override
		 public void eliminar() {
			iusuario.eliminar();
		}


		@Override
		public void modificar() {
			// TODO Auto-generated method stub
			iusuario.modificar();	
		}

		@Override
		public Usuario mostrar() {
			// TODO Auto-generated method stub
			   Usuario usuario= iusuario.mostrar();
				return usuario;
		}
}
