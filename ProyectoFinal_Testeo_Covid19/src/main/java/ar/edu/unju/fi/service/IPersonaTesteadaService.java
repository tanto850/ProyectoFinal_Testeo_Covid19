/**
 * 
 */
package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Aucachi Fabian
 *
 */
public interface IPersonaTesteadaService {
	public void guardar(PersonaTesteada personaTesteada);
	public void eliminar(long id);
 	public Iterable<PersonaTesteada> listarPersonasTesteadas();
 	public Optional<PersonaTesteada> listarPersonaId(long id);
 	public List<PersonaTesteada> listarPersonaApellido(String apellido);
 	
	public List<PersonaTesteada> listarPersonaDocumento(String dni);
	
	public List<PersonaTesteada> listarBarrioFechas(String barrio,LocalDateTime fecha1, LocalDateTime fecha2);
	public Iterable<PersonaTesteada> listarPersonasTesteadasRegistro(RegistroTesteo resgitroTesteo);
	public List<PersonaTesteada> listarPersonas();
	public boolean encontrarPersonaRegistro(PersonaTesteada unaPersonaTesteada);
}
