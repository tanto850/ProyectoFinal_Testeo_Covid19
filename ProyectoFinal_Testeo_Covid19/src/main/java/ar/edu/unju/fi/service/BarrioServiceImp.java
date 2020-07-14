/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IBarrioRepository;
import ar.edu.unju.fi.testeos.model.Barrio;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class BarrioServiceImp implements IBarrioService{
@Autowired
public IBarrioRepository iBarrio;

private Logger log = Logger.getLogger("");

	@Override
	public void guardar(Barrio barrio) {
		iBarrio.save(barrio);
		log.info("El barrio " + barrio.getNombre() + " ha sido guardado.");
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iBarrio.deleteById(id);
		log.info("El barrio ha sido eliminado.");
	
	}

	@Override
	public Barrio modificar(Barrio unBarrio) throws Exception {
		log.info(unBarrio.getNombre() + " id " + unBarrio.getId());
		return iBarrio.save(unBarrio);
	}

	@Override
	public Iterable<Barrio> listarBarrios() {
		// TODO Auto-generated method stub
		
		return iBarrio.findAll();
	}

	@Override
	public Barrio encontrarBarrio(long id) throws Exception {
		// TODO Auto-generated method stub
		return iBarrio.findById(id).orElseThrow(()-> new Exception("El barrio no existe."));
	}
}
