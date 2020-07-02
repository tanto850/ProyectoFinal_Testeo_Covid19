/**
 * 
 */
package ar.edu.unju.fi.service;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi Fabian
 *
 */
public interface IPersonaTesteadaService {
	public void guardar(PersonaTesteada personaTesteada);
	public void eliminar();
	public void modificar();
 	public Iterable<PersonaTesteada> listarPersonasTesteadas();
}
