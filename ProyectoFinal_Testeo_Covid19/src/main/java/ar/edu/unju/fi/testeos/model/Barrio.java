package ar.edu.unju.fi.testeos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "barrio")
public class Barrio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Autowired
	@OneToOne(mappedBy = "barrio" ,  fetch = FetchType.LAZY )
	@JoinColumn( name = "ID_UNIDAD" )//
	private UnidadHabitacional unidadHabitacional;
    
	/**
	 * Constructor por defecto sin parametros.
	 */
	 public Barrio(){
		
	}
	
	 
	 
	/**
	 * constructor sobrecargado
	 * @param nombre
	 */
	public Barrio(long id,String nombre) {
		this.nombre = nombre;
	}

	/**Método para acceder a la variable id;
	* @return id.
	*/
	 public long getId() {
			return this.id;
	}
	 
	/**Metodo que permite modificar la variable id.
	* @param id, variable de la clase Barrio.
	*/
	public void setId(long id) {
			this.id = id;
	}

	/** Método para obtener la variable nombre.
	 * @return nombre, variable que gaurda el nombre del barrio.
	 */
	public String getNombre() {
		return nombre;
	}

	/**Método que permite modificar la variable nombre.
	 * @param nombre, variable que guarda el nombre para almacenar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Barrio [nombre=" + nombre + "]";
	}



	/**
	 * @return the unidadHabitacional
	 */
	public UnidadHabitacional getUnidadHabitacional() {
		return unidadHabitacional;
	}



	/**
	 * @param unidadHabitacional the unidadHabitacional to set
	 */
	public void setUnidadHabitacional(UnidadHabitacional unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}
	
	
}
