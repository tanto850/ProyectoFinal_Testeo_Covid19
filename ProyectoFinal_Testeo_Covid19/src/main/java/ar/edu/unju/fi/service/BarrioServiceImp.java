/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IBarrio;
import ar.edu.unju.fi.testeos.model.Barrio;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class BarrioServiceImp implements IBarrioService{
@Autowired
public IBarrio ibarrio;

	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		ibarrio.guardar();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
	ibarrio.eliminar();
	
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		ibarrio.modificar();
	}

	@Override
	public Barrio mostrar() {
		// TODO Auto-generated method stub
		Barrio barrio = ibarrio.mostrar();
		return barrio;
	}

}
