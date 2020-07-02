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
	public void guardar(Usuario unUsuario);
	public void eliminar(long dni);
	public void modificar();
	public Iterable<Usuario> listarUsuario();
}
