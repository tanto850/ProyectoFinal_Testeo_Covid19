/**
 * 
 */
package ar.edu.unju.fi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IPersonaTesteada;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi fabian
 *
 */
@Service
public class IPersonaTesteadaServiceImp implements IPersonaTesteadaService{
	@Autowired
	public IPersonaTesteada ipersona;
	
	@Override
	 public void guardar() {
		// TODO Auto-generated method stub
		ipersona.guardar();
	}

	@Override
	public void eliminar() {
	// TODO Auto-generated method stub
		ipersona.eliminar();
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		ipersona.modificar();
	}

	@Override
	public PersonaTesteada mostrar() {
		// TODO Auto-generated method stub
		PersonaTesteada persona = ipersona.mostrar();
		return persona;
	}

}
