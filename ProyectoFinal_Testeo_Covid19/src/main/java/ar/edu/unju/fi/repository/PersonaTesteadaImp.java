package ar.edu.unju.fi.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.ProyectoFinalTesteoCovid19Aplication;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi Fabian
 *  implementacion. se escriben las acciones que realizaran los metodos de la interfaz asociada.
 */
@Repository
public class PersonaTesteadaImp implements IPersonaTesteada{
    @Autowired
	PersonaTesteada personaTesteada;
    public static Logger LOG = LoggerFactory.getLogger(ProyectoFinalTesteoCovid19Aplication.class);
	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		LOG.info("se guardo el testeo del DNI" + personaTesteada.getDocumento());
		
	}
  
	
	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		LOG.info("se elimino testeo");
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		LOG.info("Testeo Modificado");
	}

	@Override
	public PersonaTesteada mostrar() {
		// TODO Auto-generated method stub
		LOG.info("mostrando los datos de la persona testeada" + personaTesteada.getApellido());
		return personaTesteada;
	}

	@Override
	public List<PersonaTesteada> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
