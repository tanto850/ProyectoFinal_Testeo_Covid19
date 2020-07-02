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
	public void guardar(UnidadHabitacional unidadHabitacional);
	public void eliminar(long id);
	public void modificar();
	public Iterable<UnidadHabitacional> listarUnidadHabitacional();
	
}
