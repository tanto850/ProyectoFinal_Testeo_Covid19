/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.Barrio;

/**
 * Se definen los metodos que tendremos que implementar sobre la clase barrio.
 */
public interface IBarrioService {
	public void guardar(Barrio unBarrio);
	public void eliminar(long id);
	public Barrio modificar(Barrio unBarrio) throws Exception;
	public Iterable<Barrio> listarBarrios();
	public Barrio encontrarBarrio(long id) throws Exception;
	public boolean encontrarNombreBarrio(Barrio unBarrio);

}
