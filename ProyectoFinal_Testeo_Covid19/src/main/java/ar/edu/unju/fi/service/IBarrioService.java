/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.trackpersonas.model.Barrio;

/**
 * @author Aucachi Fabian
 *
 */
public interface IBarrioService {
	public void guardar();
	public void eliminar();
	public void modificar();
	public Barrio mostrar();

}
