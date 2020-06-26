package ar.edu.unju.fi.testeos.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "registro_testeo")
public class RegistroTesteo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=true)
	private long id;
	
	@Column
	@NotBlank
	private LocalDateTime fechaHora;
	
	@Autowired
	@OneToMany(mappedBy = "registroTesteo", cascade = CascadeType.ALL)
	@JoinColumn(name = "UNIDAD_HABITACIONAL_ID")
	private UnidadHabitacional unidadHabitacional;
	
	
	private List<PersonaTesteada> personasTesteadas;
	
	/**
	 * constructor por defecto.
	 */
	public RegistroTesteo() {}
	
	/**
	 * constructor sobrecargado.
	 * @param id
	 * @param fechaHora
	 * @param unidadHabitacional
	 * @param personasTesteadas
	 */
	 public RegistroTesteo(long id, LocalDateTime fechaHora, UnidadHabitacional unidadHabitacional,
			List<PersonaTesteada> personasTesteadas) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.unidadHabitacional = unidadHabitacional;
		this.personasTesteadas = personasTesteadas;
	}
	 
	/**Método para acceder a la variable id;
	* @return id.
	*/
	 public long getId() {
		 return this.id;
	}
		 
	/**Metodo que permite modificar la variable id.
	* @param id, variable de la clase RegistroTesteo.
	*/
	public void setId(long id) {
			this.id = id;
	}

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
