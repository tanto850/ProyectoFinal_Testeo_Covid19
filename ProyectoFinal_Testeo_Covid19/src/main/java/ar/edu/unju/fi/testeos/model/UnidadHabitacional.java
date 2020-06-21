package ar.edu.unju.fi.testeos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.unju.fi.trackpersonas.model.Barrio;

@Component
public class UnidadHabitacional {

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
	 * @param direccion
	 * @param barrio
	 */
	public UnidadHabitacional(String direccion, Barrio barrio) {
		this.direccion = direccion;
		this.barrio = barrio;
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
