/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * Se definen los metodos que tendremos que implementar sobre la clase UnidadHabitacional
 */
public interface IUnidadHabitacionalService {
	public void guardar(UnidadHabitacional unidadHabitacional);
	public void eliminar(long id);
	public void modificar();
	public Iterable<UnidadHabitacional> listarUnidadHabitacional();
	public Iterable<UnidadHabitacional> listarUnidad();
	
}
