/**
 * 
 */
package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * @author Fabian
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */
public interface IUsuario {
	public void guardar();
	public void eliminar();
	public void modificar();
	public Usuario mostrar();
	
}
