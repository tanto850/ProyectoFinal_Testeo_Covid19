package ar.edu.unju.fi.testeos.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class RegistroTesteo {
	
	public LocalDateTime fechaHora;
	@Autowired
	public UnidadHabitacional unidadHabitacional;
	public List<PersonaTesteada> personasTesteadas;
	
	/**Metodo para obtener la fecha y hora del testeo.
	 * @return fechaHora, variable de la clase RegistroTesteo.
	 */
	public LocalDateTime getFechaHora() {
		return this.fechaHora;
	}
	
	/**Metodo para modificar la varible fechaHora.
	 * @param fechaHora, varible para modificar fechaHora.
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	/**Metodo para obtener la variable unidadHabitacional.
	 * @return unidadHabitacional, variable de la clase RegistroTesteo.
	 */
	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}
	
	/**Metodo para modificar la varible unidadHabitacional.
	 * @param unidadHabitacional, variable de la clase RegistroTesteo.
	 */
	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}
	
	/**Metodo para acceder a la lista de personas testeadas.
	 * @return personasTesteadas
	 */
	public List<PersonaTesteada> getPersonasTesteadas() {
		return personasTesteadas;
	}
	
	/**
	 * @param personasTesteadas the personasTesteadas to set
	 */
	public void setPersonasTesteadas(List<PersonaTesteada> personasTesteadas) {
		this.personasTesteadas = personasTesteadas;
	}

	@Override
	public String toString() {
		return "RegistroTesteo [fechaHora=" + fechaHora + ", unidadHabitacional=" + unidadHabitacional
				+ ", personasTesteadas=" + personasTesteadas + "]";
	}

}
