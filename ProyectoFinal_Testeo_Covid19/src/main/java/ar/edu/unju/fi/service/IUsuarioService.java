/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * @author Aucachi Fabian
 *
 */
public interface IUsuarioService {
	public void guardar();
	public void eliminar();
	public void modificar();
	 public Usuario mostrar();
}
