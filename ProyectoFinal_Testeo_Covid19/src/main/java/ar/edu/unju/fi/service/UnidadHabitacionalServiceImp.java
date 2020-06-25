/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUnidadHabitacional;
import ar.edu.unju.fi.testeos.model.UnidadHabitacional;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class UnidadHabitacionalServiceImp implements IUnidadHabitacionalService {
@Autowired
	public IUnidadHabitacional iunidad;
	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		iunidad.guardar();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		iunidad.eliminar();
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		 iunidad.modificar();
	}

	@Override
	public UnidadHabitacional mostrar() {
		// TODO Auto-generated method stub
		UnidadHabitacional unidad = iunidad.mostrar();
		return unidad;
	}

}
