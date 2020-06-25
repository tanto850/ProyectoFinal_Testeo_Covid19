/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IRegistroTesteo;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class IRegistroTesteoServiceImp implements IRegistroTesteoService {
@Autowired	
public IRegistroTesteo iregistro;

@Override
	public void guardar() {
		// TODO Auto-generated method stub
         iregistro.guardar();
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		iregistro.eliminar();
	}

	@Override
	public RegistroTesteo mostrar() {
		// TODO Auto-generated method stub
		RegistroTesteo registro = iregistro.mostrar();
		return registro;
	}

}
