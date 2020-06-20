package ar.edu.unju.fi.testeos.model;

public class PersonaTesteada {

	private String documento;
	private String apellido;
	private String nombres;
	private String resultadoTesteo;
	
	
	/** Metodo que permite obtener el documento guardado.
	 * @return el documento guardado en la variable miembro de la clase PersonaTesteada.
	 */
	public String getDocumento() {
		return this.documento;
	}
	
	/** Método que permite modificar documento, variable miembro privada de la clase PersonaTesteada.
	 * @param documento, variable que guarda el documento que se desea almacenar.
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	/**Metodo que permite obtener el apellido guardado.
	 * @return el apellido de PersonaTesteada.
	 */
	public String getApellido() {
		return this.apellido;
	}
	
	/**Método que permite modificar apellido, variable miembro privada de la clase PersonaTesteada
	 * @param apellido, variabla que guarda el apellido que se desea almacenar.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**Método que permite obtener los nombres guardados.
	 * @return los nombres guardados de la clase PersonaTesteada.
	 */
	public String getNombres() {
		return this.nombres;
	}
	
	/**Método que permite modificar nombres, variable miembro privada de la clase PersonaTesteada
	 * @param nombres, variable que guarda los nombres que se desea almacenar.
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	/**Metodo que permite obtener resultadoTesteo
	 * @return resultadoTesteo guardado en la clase PersonaTesteada.
	 */
	public String getResultadoTesteo() {
		return this.resultadoTesteo;
	}
	
	/**Método que permite modificar resultadoTesteo, variable miembro privada de la clase PersonaTesteada
	 * @param resultadoTesteo, variable el resultado que desea almacenar.
	 */
	public void setResultadoTesteo(String resultadoTesteo) {
		this.resultadoTesteo = resultadoTesteo;
	}

	@Override
	public String toString() {
		return "PersonaTesteada [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", resultadoTesteo=" + resultadoTesteo + "]";
	}
	
	
}
