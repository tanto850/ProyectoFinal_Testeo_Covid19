package ar.edu.unju.fi.testeos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase que representa un Objeto barrio 
 * Clase que corresponde a una tabla de la base de datos.
 *
 */

@Component
@Entity
@Table(name = "barrio")
public class Barrio {
	
	/**
	 * Atributo para identificar cada registro de esta clase
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	/**
	 * Atributo que representa el nombre de un barrio
	 */
	@Column(name = "NOMBRE")
	private String nombre;
	
	/**
	 * Atributo que representa un listado de las unidades habitacionales
	 */
	@Autowired
	/*@OneToMany(mappedBy = "barrio" ,  fetch = FetchType.LAZY )*/
	@OneToMany(mappedBy ="barrio", cascade = CascadeType.ALL)
	private List<UnidadHabitacional> unidadHabitacional;
    
	//----------CONSTRUCTORES----------
	
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

	//------------METODOS ACCESORES------------
	
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
	
	/**
	 * Metodo sobreescrito
	 */
	@Override
	public String toString() {
		return this.nombre;
	}

/**
 * metodo get, permite obtener la variable miembro del obj
 * @return
 */
	public List<UnidadHabitacional> getUnidadHabitacional() {
		return unidadHabitacional;
	}


/**
 * metodo set, permite modificar la lista correspondiente a la variable miembro
 * @param unidadHabitacional
 */
	public void setUnidadHabitacional(List<UnidadHabitacional> unidadHabitacional) {
		this.unidadHabitacional = unidadHabitacional;
	}


}
