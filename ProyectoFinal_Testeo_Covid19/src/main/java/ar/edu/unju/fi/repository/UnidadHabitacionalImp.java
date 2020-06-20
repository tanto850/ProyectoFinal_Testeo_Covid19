package ar.edu.unju.fi.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.ProyectoFinalTesteoCovid19Aplication;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * @author Aucachi Fabian
 *  implementacion. se escriben las acciones que realizaran los metodos de la interfaz asociada.
 */
@Repository
public class UnidadHabitacionalImp implements IUnidadHabitacional{
	@Autowired
UnidadHabitacional unidadHabitacional;
	public static Logger LOG = LoggerFactory.getLogger(ProyectoFinalTesteoCovid19Aplication.class);
	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		LOG.info("Unidad habitacional guardada");
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		LOG.info("Unidad habitacional eliminada");
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		LOG.info("Unidad habitacional modificada");
	}

	@Override
	public UnidadHabitacional mostrar() {
		// TODO Auto-generated method stub
		LOG.info("se esta mostrando" + unidadHabitacional.getDireccion());
		return unidadHabitacional;
	}
}
