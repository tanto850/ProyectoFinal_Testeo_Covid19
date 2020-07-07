/**
 * 
 */
package ar.edu.unju.fi.repository;
//import java.util.List;
//import java.util.Optional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Fabian
 * Se definiran que metodos se realizaran sobre el objeto con la que asociamos la interface
 *

public interface IPersonaTesteada {
	public void guardar();
	public void eliminar();
	 public void modificar();
 	public PersonaTesteada mostrar();
 // public List<PersonaTesteada> mostrarTodos();
  
}*/

public interface IPersonaTesteadaRepository extends JpaRepository<PersonaTesteada,Long>{
	
	public List<PersonaTesteada> findByApellidoContaining(String apellido);
	public List<PersonaTesteada> findByDocumentoContaining(String dni);
	public List<PersonaTesteada> findByRegistroTesteoUnidadHabitacionalBarrioNombreAndRegistroTesteoFechaHoraBetween(LocalDate fecha1, LocalDate fecha2, String barrio);
	public List<PersonaTesteada> findByRegistroTesteoUnidadHabitacionalBarrioNombreAndRegistroTesteoFechaHoraBetween(LocalTime hora1, LocalTime hora2, String barrio);	   


}
