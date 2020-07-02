/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.Optional;

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
public IRegistroTesteoRepository iRegistro;

@Override
	public void guardar(RegistroTesteo registroTesteo) {
		// TODO Auto-generated method stub
		iRegistro.save(registroTesteo);
		System.out.println("El registro fue guardado.");
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iRegistro.deleteById(id);
	}

	@Override
	public Optional<RegistroTesteo> mostrar(long id) {
		// TODO Auto-generated method stub
		
		return iRegistro.findById(id);
	}

}
