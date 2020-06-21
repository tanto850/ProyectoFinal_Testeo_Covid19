package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;
/**
 * 
 * @author Aucachi Fabian
 *
 */
public interface IRegistroTesteoService {
	public void guardar();
	public void eliminar();
	public RegistroTesteo mostrar();
}
