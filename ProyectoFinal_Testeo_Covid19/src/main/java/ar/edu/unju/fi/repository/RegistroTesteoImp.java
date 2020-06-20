package ar.edu.unju.fi.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.ProyectoFinalTesteoCovid19Aplication;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Aucachi Fabian
 *  implementacion. se escriben las acciones que realizaran los metodos de la interfaz asociada.
 */
@Repository
public class RegistroTesteoImp implements IRegistroTesteo {
//@Autowired	
//RegistroTesteo registroTesteo;
public static Logger LOG = LoggerFactory.getLogger(ProyectoFinalTesteoCovid19Aplication.class);
@Override
public void guardar() {
	// TODO Auto-generated method stub
	LOG.info("se Registro el testeo");
}

@Override
public void eliminar() {
	// TODO Auto-generated method stub
	LOG.info("Testeo eliminado");
	
}

@Override
public RegistroTesteo mostrar() {
	return null;
}
}
