package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.testeos.model.Barrio;
/**
 * 
 * @author Fabian
  * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */
public interface IBarrio {
	 public void guardar();
	public void eliminar();
	public void modificar();
	public Barrio mostrar();
}
