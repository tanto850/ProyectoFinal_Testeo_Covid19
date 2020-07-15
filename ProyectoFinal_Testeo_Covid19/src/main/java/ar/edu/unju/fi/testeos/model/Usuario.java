package ar.edu.unju.fi.testeos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Clase que represente un objeto tipo Usuario
 * Clase que corresponde a una tabla de la base de datos.
 *
 */

@Component
@Entity
@Table(name = "usuario")
public class Usuario {
	
	
	/**
	 * Atributo para identificar cada registro de esta clase
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=true)
	private long id;
	
	/**
	 * Atributo que representa el nombre del usuario
	 */
	@Column (unique = true)
	@NotBlank
	private String nombreUsuario;
	
	/**
	 * Atributo que representa la contraseña del Usuario
	 */
	@Column
	@NotBlank
	@Size(min=8, message="Su contraseña debe tener como minimo 8 caracteres.")
	private String password;
	
	/**
	 * Atributo que representa el nombre real del Usuario
	 */
	@Column
	@NotBlank
	private String nombreReal;
	
	/**
	 * Atributo que representa el apellido del Usuario
	 */
	@Column
	@NotBlank
	private String apellidoReal;
	
	/**
	 * Atributo que representa el tipo de Usuario que es..(CONSULTOR-REGISTRADOR-BD)
	 */
	@Column
	@NotBlank
	private String tipoUsuario;
	
	// -------------- CONSTRUCTORES -------------
	
	/**
	 * Constructor por defecto.
	 */
	public Usuario() {}
	
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param id
	 * @param nombreUsuario
	 * @param password
	 * @param nombreReal
	 * @param apellidoReal
	 * @param tipoUsuario
	 */
	 public Usuario(long id,String nombreUsuario, String password, String nombreReal, String apellidoReal, String tipoUsuario) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombreReal = nombreReal;
		this.apellidoReal = apellidoReal;
		this.tipoUsuario = tipoUsuario;
	}
	 
	 //------------- METODOS ACCESORES ---------------
	 
	 
	/**Método para acceder a la variable id;
	* @return id.
	*/
	 public long getId() {
			return this.id;
	}
	 
	/**Metodo que permite modificar la variable id.
	* @param id, variable de la clase Usuario.
	*/
	public void setId(long id) {
			this.id = id;
	}


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
	
	//-------------- METODO SOBREESCRITO --------------
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", nombreReal=" + nombreReal
				+ ", apellidoReal=" + apellidoReal + ", tipoUsuario=" + tipoUsuario + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidoReal == null) ? 0 : apellidoReal.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreReal == null) ? 0 : nombreReal.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
		return result;
	}

/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidoReal == null) {
			if (other.apellidoReal != null)
				return false;
		} else if (!apellidoReal.equals(other.apellidoReal))
			return false;
		if (id != other.id)
			return false;
		if (nombreReal == null) {
			if (other.nombreReal != null)
				return false;
		} else if (!nombreReal.equals(other.nombreReal))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tipoUsuario == null) {
			if (other.tipoUsuario != null)
				return false;
		} else if (!tipoUsuario.equals(other.tipoUsuario))
			return false;
		return true;
	}

	*/
}
