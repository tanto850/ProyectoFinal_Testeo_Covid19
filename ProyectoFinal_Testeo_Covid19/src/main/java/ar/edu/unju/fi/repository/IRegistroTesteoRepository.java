/**
 * 
 */
package ar.edu.unju.fi.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;


public interface IRegistroTesteoRepository extends JpaRepository<RegistroTesteo, Long>{
	
	public RegistroTesteo findByFechaHora(LocalDateTime fechaHora);
}