/**
 * 
 */
package ar.edu.unju.fi.repository;
//import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Fabian
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */

public interface IPersonaTesteada {
	public void guardar();
	public void eliminar();
	 public void modificar();
 	public PersonaTesteada mostrar();
 // public List<PersonaTesteada> mostrarTodos();
  
}
