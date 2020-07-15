/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	/**
	 *Metodo para buscar el nombre del usuario en la capa repositorio. 
	 * @param nombreUsuario
	 * @return retorna un objeto tipo Optional que sera analizada para saber si contiene un resultado
	 * valido
	 */
	public Optional<Usuario> findByNombreUsuario(String nombreUsuario);
	
}