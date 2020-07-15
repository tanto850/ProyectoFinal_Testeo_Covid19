/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * Interface donde extendemos las herramientas del JPA y definimos algunas funciones a realizar(tambien del jpa)
 */
public interface IUnidadHabitacionalRepository extends JpaRepository<UnidadHabitacional,Long>{
	
}