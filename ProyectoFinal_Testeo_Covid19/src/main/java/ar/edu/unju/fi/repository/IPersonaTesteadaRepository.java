/**
 * 
 */
package ar.edu.unju.fi.repository;
//import java.util.List;
//import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;
//import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 *
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 */

public interface IPersonaTesteadaRepository extends JpaRepository<PersonaTesteada,Long>{
	public List<PersonaTesteada> findByApellidoContaining(String apellido);
	public List<PersonaTesteada> findByDocumentoContaining(String dni);
	public List<PersonaTesteada> findByRegistroTesteoUnidadHabitacionalBarrioNombreAndRegistroTesteoFechaHoraBetweenOrderByRegistroTesteoUnidadHabitacional( String barrio, LocalDateTime fecha1, LocalDateTime fecha2);
	public Iterable<PersonaTesteada> findByRegistroTesteo(RegistroTesteo registroTesteo);
	public Optional<PersonaTesteada> findByDocumentoAndRegistroTesteo(RegistroTesteo registroTesteo, String documento);
	
}
