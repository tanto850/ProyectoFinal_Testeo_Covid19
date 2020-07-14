/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUnidadHabitacionalRepository;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class UnidadHabitacionalServiceImp implements IUnidadHabitacionalService {
	
	@Autowired
	public IUnidadHabitacionalRepository iUnidadHabitacional;

	private Logger log = Logger.getLogger("");
	
	@Override
	public void guardar(UnidadHabitacional unidadHabitacional) {
		// TODO Auto-generated method stub
		iUnidadHabitacional.save(unidadHabitacional);
		log.info("La unidad habitacional se guardo correctamente.");
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iUnidadHabitacional.deleteById(id);;
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		 //iunidad.modificar();
	}

	@Override
	public Iterable<UnidadHabitacional> listarUnidadHabitacional() {
		// TODO Auto-generated method stub
		//UnidadHabitacional unidad = iunidad.mostrar();
		return iUnidadHabitacional.findAll();
	}

	@Override
	public Iterable<UnidadHabitacional> listarUnidad() {
		// TODO Auto-generated method stub
		return iUnidadHabitacional.findAll();
	}

}
