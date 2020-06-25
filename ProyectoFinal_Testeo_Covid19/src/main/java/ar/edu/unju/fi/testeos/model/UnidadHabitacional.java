package ar.edu.unju.fi.testeos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.testeos.model.Barrio;

@Component
public class UnidadHabitacional {

	private long id;
	private String direccion;
	@Autowired
	private Barrio barrio;
	
	/**
	 * constructor por defecto.
	 */
	 public UnidadHabitacional() {
		
	}
	
	/**
	 * constructor sobrecargado
	 * @param id
	 * @param direccion
	 * @param barrio
	 */
	public UnidadHabitacional(long id, String direccion, Barrio barrio) {
		this.id = id;
		this.direccion = direccion;
		this.barrio = barrio;
	}
	
	/**Método para acceder a la variable id;
	* @return id.
	*/
	 public long getId() {
		 return this.id;
	}
		 
	/**Metodo que permite modificar la variable id.
	* @param id, variable de la clase UnidadHabitacional.
	*/
	public void setId(long id) {
			this.id = id;
	}

	/**Método para obtener la variable direccion.
	 * @return direccion, variable de la clase UnidadHabitacional.
	 */
	public String getDireccion() {
		return this.direccion;
	}
	
	/**Método que permite modificar la variable direccion.
	 * @param direccion, variable que guarda la direccion a almacenar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**Metodo para obtener la variable barrio.
	 * @return barrio, variable de la clase UnidadHabitacional.
	 */
	public Barrio getBarrio() {
		return barrio;
	}
	
	/**Metodo que permite modificar la varible barrio.
	 * @param barrio, variable que gaurda el barrio a almacenar.
	 */
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
	@Override
	public String toString() {
		return "UnidadHabitacional [direccion=" + direccion + ", barrio=" + barrio + "]";
	}
	
}
