package ar.edu.unju.fi.service;

import java.util.Optional;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;
/**
 * 
 * @author Aucachi Fabian
 *
 */
public interface IRegistroTesteoService {
	public void guardar(RegistroTesteo resgistroTesteo);
	public void eliminar(long id);
	public Optional<RegistroTesteo> mostrar(long id);
}
