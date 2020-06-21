package ar.edu.unju.fi.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.ProyectoFinalTesteoCovid19Aplication;
import ar.edu.unju.fi.trackpersonas.model.Barrio;

/**
 * @author Aucachi Fabian
 *  implementacion. se escriben las acciones que realizaran los metodos de la interfaz asociada.
 */
@Repository
public class BarrioImp implements IBarrio{
   @Autowired
	Barrio barrio;
    public static Logger LOG = LoggerFactory.getLogger(ProyectoFinalTesteoCovid19Aplication.class);
@Override
public void guardar() {
	// TODO Auto-generated method stub
	LOG.info("se guardaron los datos del barrio");
}

@Override
public void eliminar() {
	// TODO Auto-generated method stub
	LOG.info("Eliminado Correctamente");
}


@Override
public void modificar() {
	// TODO Auto-generated method stub
	LOG.info("modificado correctamente");
}

@Override
public Barrio mostrar() {
	// TODO Auto-generated method stub
	LOG.info("Mostrando");	
	return null;
}
}
