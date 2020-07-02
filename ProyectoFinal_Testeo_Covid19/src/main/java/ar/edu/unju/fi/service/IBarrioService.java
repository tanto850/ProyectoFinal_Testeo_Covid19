/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.Barrio;

/**
 * @author Aucachi Fabian
 *
 */
public interface IBarrioService {
	public void guardar(Barrio barrio);
	public void eliminar(long id);
	public void modificar();
	public Iterable<Barrio> listarBarrios();

}
