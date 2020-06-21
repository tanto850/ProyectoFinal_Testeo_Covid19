/**
 * 
 */
package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * @author Fabian
  * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */
public interface IUnidadHabitacional {
	public void guardar();
	public void eliminar();
	public void modificar();
	 public UnidadHabitacional mostrar();
	
}
