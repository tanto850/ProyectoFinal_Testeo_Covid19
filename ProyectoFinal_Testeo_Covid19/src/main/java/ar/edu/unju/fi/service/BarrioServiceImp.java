/**
 * 
 */
package ar.edu.unju.fi.service;

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

	@Override
	public void guardar(Barrio barrio) {
		iBarrio.save(barrio);
		System.out.println("El barrio " + barrio.getNombre() + " ha sido guardado.");
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iBarrio.deleteById(id);
	
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		//ibarrio.modificar();
	}

	@Override
	public Iterable<Barrio> listarBarrios() {
		// TODO Auto-generated method stub
		
		return iBarrio.findAll();
	}

}
