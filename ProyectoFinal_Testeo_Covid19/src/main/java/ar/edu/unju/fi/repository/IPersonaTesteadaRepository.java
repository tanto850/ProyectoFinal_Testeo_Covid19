/**
 * 
 */
package ar.edu.unju.fi.repository;
//import java.util.List;
//import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;
//import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 *
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */

public interface IPersonaTesteadaRepository extends JpaRepository<PersonaTesteada,Long>{
	
	
	/**
	 * Método que permite la búsqueda de personas testeadas por su apellido.
	 * @param apellido que se desea filtrar.
	 * @return una lista de personas testeadas con el apellido indicado.
	 */
	public List<PersonaTesteada> findByApellidoContaining(String apellido);
	
	
	/**
	 * Método que permite la búsqueda de personas testeadas por su Dni;
	 * @param dni que se desea filtrar.
	 * @return una lista de personas testeadas con el dni indicado.
	 */
	public List<PersonaTesteada> findByDocumentoContaining(String dni);
	
	
	/**
	 * Método que permite la búsqueda de personas testeadas según el barrio, entre unas fechas determinadas
	 * y en un horario determinado.
	 * @param barrio que se desea filtrar.
	 * @param fecha1 que se desea filtrar.
	 * @param fecha2 que se desea filtrar.
	 * @return una lista de personas testeadas.
	 */
	public List<PersonaTesteada> findByRegistroTesteoUnidadHabitacionalBarrioNombreAndRegistroTesteoFechaHoraBetweenOrderByRegistroTesteoUnidadHabitacionalDireccion( String barrio, LocalDateTime fecha1, LocalDateTime fecha2);
	
	
	/**
	 *Método que permite la búsqueda de personas testeadas segun el id del registroTesteo. 
	 * @param registroTesteo que se desea filtrar.
	 * @return un iterable de personas testeadas.
	 */
	public Iterable<PersonaTesteada> findByRegistroTesteo(RegistroTesteo registroTesteo);
	
	
	/**
	 * Método que permite la búsqueda de personas testeadas según el registro testeo y 
	 * su documento.
	 * @param registroTesteo
	 * @param documento
	 * @return
	 */
	public List<PersonaTesteada> findByRegistroTesteoAndDocumento(RegistroTesteo registroTesteo, String documento);
	
}
