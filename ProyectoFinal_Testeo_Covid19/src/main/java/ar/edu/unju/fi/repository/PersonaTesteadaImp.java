/**
 * 
 */
package ar.edu.unju.fi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.testeos.model.PersonaTesteada;

/**
 * @author Aucachi
 *
 */
@Repository
public class PersonaTesteadaImp implements IPersonaTesteada{
@Autowired
	PersonaTesteada  persona;
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
