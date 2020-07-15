package ar.edu.unju.fi.testeos.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase que registra testeos con sus respectivos datos..
 * El registro lleva unidad habitacional, personas testeadas y hora del registro
 * 
 * @author Jose
 *
 */

@Component
@Entity
@Table( name = "registro_testeo")
public class RegistroTesteo {
	/**
	 * Atributo para identificar cada registro de esta clase
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "ID")//, nullable=true)
	private long id;
	
	/**
	 * Atributo que representa la hora del registro
	 */
	@Column( name = "FECHAHORA")
	private LocalDateTime fechaHora;
	
	/**
	 * Atributo de tipo unidadHabitacional, contiene todos los datos de una unidad habitacional
	 */
	@Autowired
	@ManyToOne( fetch  = FetchType.LAZY )//( mappedBy = "registroTesteo", cascade = CascadeType.ALL)
	@JoinColumn( name = "unidadHabitacional_ID" )
	private UnidadHabitacional unidadHabitacional;
	
	/**
	 * Atributo que representa listado de las personas testeadas
	 */
	@OneToMany(mappedBy ="registroTesteo", cascade = CascadeType.ALL)
	private List<PersonaTesteada> personasTesteadas;
	
	//-----------CONSTRUCTORES-------------
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
		//this.personasTesteadas = personasTesteadas;
	}
	 
	 
	 //------------METODOS ACCESORES-----------------
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
	//public List<PersonaTesteada> getPersonasTesteadas() {
		//return personasTesteadas;
	//}
	
	/**
	 * @param personasTesteadas the personasTesteadas to set
	 */
	//Public void setPersonasTesteadas(List<PersonaTesteada> personasTesteadas) {
	//	this.personasTesteadas = personasTesteadas;
//	}

	//@Override
//	public String toString() {
		//return "RegistroTesteo [fechaHora=" + fechaHora + ", unidadHabitacional=" + unidadHabitacional
		//		+ ", personasTesteadas=" + personasTesteadas + "]";
	//}

}
