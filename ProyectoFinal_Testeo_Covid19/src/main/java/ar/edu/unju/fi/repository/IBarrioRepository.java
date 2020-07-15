package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.Barrio;
/**
 * Interface donde extendemos las herramientas del JPA y definimos algunas funciones a realizar(tambien del jpa)
 */
public interface IBarrioRepository extends JpaRepository<Barrio, Long>{
	
	public Optional<Barrio> findByNombre(String nombreBarrio);
	
}
