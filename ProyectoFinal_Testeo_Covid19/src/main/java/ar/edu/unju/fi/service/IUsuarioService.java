/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * Interfaz que permite desarrollar la logica del proyecto y a la vez conectarse 
 * con los datos de se encuentra en el repositorio de datos.
 *
 */
public interface IUsuarioService {
	
	/**
	 * Metodo que permite guardar un usuario en el gestor de MySQL	
	 * @param unUsuario , usuario a guardar
	 */
	public void guardar(Usuario unUsuario);
	
	/**
	 * Metodo que permite eliminar un usuario
	 * 
	 * @param dni 
	 */
	public void eliminar(long dni);
	
	/**
	 * Metodo que permite guardar los datos modificados de un usuario
	 * @param usuario
	 * @return el usuario con los datos modificados
	 * @throws Exception
	 */
	public Usuario modificar(Usuario usuario) throws Exception;
	
	/**
	 * Metodo que devuelve una lista de los usuarios registrado
	 * @return lista de los usuarios
	 */
	public Iterable<Usuario> listarUsuario();
	
	/**
	 * Metodo que permite buscar un Usuario particular segun su ID
	 * @param id
	 * @return Usuario encontrado
	 * @throws Exception definida para trata situaciones en caso de que no se encuentre nada en la busqueda
	 */
	public Usuario encontrarUsuario2(Long id) throws Exception;
	
	/**
	 * Metodo que permite buscar un Usuario particular segun su nombre de Usuario
	 * @param nombreUsuario
	 * @return Usuario encontrado
	 * @throws Exception definida para trata situaciones en caso de que no se encuentre nada en la busqueda
	 */
	public Usuario encontrarUsuario(String nombreUsuario) throws Exception;
	
	/**
	 * Metodo que permite saber si hay existe un usuario
	 * @param unUsuario
	 * @return Retorna un valor booleano
	 */
	public boolean encontrarNombreUsuario(Usuario unUsuario);
}
