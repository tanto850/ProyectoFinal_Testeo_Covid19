/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IPersonaTesteadaRepository;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi fabian
 *
 */
@Service
public class PersonaTesteadaServiceImp implements IPersonaTesteadaService{
	
	@Autowired
	public IPersonaTesteadaRepository ipersona;

	@Override
	public void guardar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonaTesteada mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

}
