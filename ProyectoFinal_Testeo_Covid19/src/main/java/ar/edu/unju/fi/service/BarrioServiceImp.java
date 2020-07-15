/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IBarrioRepository;
import ar.edu.unju.fi.testeos.model.Barrio;

/**
 * implementador de la interface del servicio de barrio, se definen como actuaran las peticiones.
 */
@Service
public class BarrioServiceImp implements IBarrioService{
@Autowired
public IBarrioRepository iBarrio;


private Logger log = Logger.getLogger("");

    /**
     * Alta del barrio
     */
	@Override
	public void guardar(Barrio barrio) {
		iBarrio.save(barrio);
		log.info("El barrio " + barrio.getNombre() + " ha sido guardado.");
	}

	/**
	 * eliminar un barrio enviando su id.
	 */
	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iBarrio.deleteById(id);
		log.info("El barrio ha sido eliminado.");
	}

	/**
	 * modificar el barrio, gracias al jpa
	 */
	@Override
	public Barrio modificar(Barrio unBarrio) throws Exception {
		log.info("se va a modificar el siguiente barrio : " + unBarrio.getNombre() + " id " + unBarrio.getId());
		return iBarrio.save(unBarrio);
	}

	/**
	 * metodo para listar todos los barrios
	 */
	@Override
	public Iterable<Barrio> listarBarrios() {
		// TODO Auto-generated method stub
		
		return iBarrio.findAll();
	}

	/**
	 * metodo para buscar un barrio por su id
	 */
	@Override
	public Barrio encontrarBarrio(long id) throws Exception {
		// TODO Auto-generated method stub
		return iBarrio.findById(id).orElseThrow(()-> new Exception("El barrio no existe."));
	}

	/**
	 * metodo para buscar un barrio por su nombre retorna boolean
	 */
	@Override
	public boolean encontrarNombreBarrio(Barrio unBarrio) {
		Optional<Barrio> barrioBuscado = iBarrio.findByNombre(unBarrio.getNombre());
		return barrioBuscado.isPresent();
	}
}
