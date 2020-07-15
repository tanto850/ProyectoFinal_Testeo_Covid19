package ar.edu.unju.fi.testeos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase que representa los datos de una persona testeada
 * Clase que corresponde a una tabla de la base de datos.
 *
 */
@Component
@Entity
@Table(name = "persona_testeada")
public class PersonaTesteada {

	/**
	 * Atributo para identificar cada registro de esta clase
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=true)
	private long id;
	
	/**
	 * Atributp que representa el numero de documento de la persona
	 */
	@Column
    @NotBlank
	private String documento;
	
	/**
	 * Atributo que representa el apellido de la persona
	 */
	@Column
	@NotBlank(message="El apellido no puede quedar en blanco")
	private String apellido;
	
	/**
	 * Atributo que representa el nombre de la persona
	 */
	@Column
	@NotBlank
	private String nombres;
	
	/**
	 * Atributo que representa el resultado del testeo realizado a la persona
	 */
	@Column
	private String resultadoTesteo;
	
	/**
	 * Atributo de tipo registroTesteo, contiene el registro de los testeos
	 */
	@Autowired
	@ManyToOne( fetch  = FetchType.LAZY )
	@JoinColumn( name = "ID_REGISTRO")
	private RegistroTesteo registroTesteo;
	
	//-----------CONSTRUCTORES--------
	/**
	 * constructor por defecto.
	 */
	 public PersonaTesteada() {
		 
	 }
	
	/**
	 * Constructor parametrizado
	 * @param id
	 * @param documento
	 * @param apellido
	 * @param nombres
	 * @param resultadoTesteo
	 */
	public PersonaTesteada(long id, String documento, String apellido, String nombres, String resultadoTesteo) {
		this.id = id;
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.resultadoTesteo = resultadoTesteo;
	}
	
	//----------METODOS ACCESORES--------------
	/**Método para acceder a la variable id;
	* @return id.
	*/
	 public long getId() {
			return this.id;
	}
	 
	/**Metodo que permite modificar la variable id.
	* @param id, variable de la clase PersonaTesteada.
	*/
	public void setId(long id) {
			this.id = id;
	}

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
	
	//--------------METODO SOBREESCRITO-------------
	
	@Override
	public String toString() {
		return "PersonaTesteada [documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", resultadoTesteo=" + resultadoTesteo + "]";
	}

	/**
	 * @return the registroTesteo
	 */
	public RegistroTesteo getRegistroTesteo() {
		return registroTesteo;
	}

	/**
	 * @param registroTesteo the registroTesteo to set
	 */
	public void setRegistroTesteo(RegistroTesteo registroTesteo) {
		this.registroTesteo = registroTesteo;
	}
	
	
}
