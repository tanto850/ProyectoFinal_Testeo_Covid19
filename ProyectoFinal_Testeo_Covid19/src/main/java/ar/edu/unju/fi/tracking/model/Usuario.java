package ar.edu.unju.fi.tracking.model;

public class Usuario {
	
	private String nombreUsuario;
	private String password;
	private String nombreReal;
	private String apellidoReal;
	private String tipoUsuario; //consultor-registrador-bd
	
	/**Método para acceder a la variable nombreUsuario;
	 * @return nombreUsuario.
	 */
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	/**Metodo que permite modificar la variable nombreUsuario.
	 * @param nombreUsuario, variable de la clase Usuario.
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	/**Método para acceder a la variable password;
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**Metodo que permite modificar la variable password.
	 * @param password, variable de la clase Usuario.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**Método para acceder a la variable nombreReal;
	 * @return nombreReal
	 */
	public String getNombreReal() {
		return this.nombreReal;
	}
	
	/**Metodo que permite modificar la variable nombreReal.
	 * @param nombreReal, variable de la clase Usuario.
	 */
	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}
	
	/**Método para acceder a la variable apellidoReal;
	 * @return apellidoReal
	 */
	public String getApellidoReal() {
		return this.apellidoReal;
	}
	
	/**Metodo que permite modificar la variable apellidoReal.
	 * @param apellidoReal, variable de la clase Usuario.
	 */
	public void setApellidoReal(String apellidoReal) {
		this.apellidoReal = apellidoReal;
	}
	
	/**Método para acceder a la variable tipoUsuario;
	 * @return tipoUsuario
	 */
	public String getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	/**Metodo que permite modificar la variable tipoUsuario.
	 * @param tipoUsuario, variable de la clase Usuario.
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}

}
