/**
 * 
 */
package ar.edu.unju.fi.service;


import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi Fabian
 *
 */
public interface IPersonaTesteadaService {
	public void guardar(PersonaTesteada personaTesteada);
	public void eliminar(long id);
	public void modificar();
 	public Iterable<PersonaTesteada> listarPersonasTesteadas();
 	public Optional<PersonaTesteada> listarPersonaId(long id);
 	public List<PersonaTesteada> listarPersonaApellido(String apellido);
 	
	public List<PersonaTesteada> listarPersonaDocumento(long dni);
 	
}
