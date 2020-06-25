package ar.edu.unju.fi.testeos.model;

import org.springframework.stereotype.Component;

@Component
public class Barrio {
	
	private long id;
	private String nombre;
    
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
	
	
}
