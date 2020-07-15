/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * Interface donde extendemos las herramientas del JPA y definimos algunas funciones a realizar(tambien del jpa)
 */
public interface IRegistroTesteoRepository extends JpaRepository<RegistroTesteo, Long>{
	
	public RegistroTesteo findByFechaHora(LocalDateTime fechaHora);
}