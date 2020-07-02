/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * @author Fabian
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 *
public interface IUsuario {
	public void guardar();
	public void eliminar();
	public void modificar();
	public Usuario mostrar();
	 
}*/

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
}