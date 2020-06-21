/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * @author Aucachi Fabian
 *
 */
public interface IUnidadHabitacionalService {
	public void guardar();
	public void eliminar();
	public void modificar();
	public UnidadHabitacional mostrar();
	
}
