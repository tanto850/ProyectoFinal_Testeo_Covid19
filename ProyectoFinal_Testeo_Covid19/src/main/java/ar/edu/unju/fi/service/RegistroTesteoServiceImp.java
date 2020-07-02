/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IRegistroTesteoRepository;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * @author Aucachi Fabian
 *
 */
@Service
public class RegistroTesteoServiceImp implements IRegistroTesteoService {
@Autowired	
public IRegistroTesteoRepository iregistro;

@Override
	public void guardar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegistroTesteo mostrar() {
		// TODO Auto-generated method stub
		//RegistroTesteo registro = iregistro.findAll();
		return null;
	}

}
