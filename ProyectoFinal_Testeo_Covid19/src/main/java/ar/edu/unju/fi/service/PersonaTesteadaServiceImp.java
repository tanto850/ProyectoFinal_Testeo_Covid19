/**
 * 
 */
package ar.edu.unju.fi.service;

import java.util.Optional;

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
	public void guardar(PersonaTesteada personaTesteada) {
		
		ipersona.save(personaTesteada);
		System.out.println("La persona de apellido "+ personaTesteada.getApellido()+ " ha sido resgistrada en la base de datos.");
	}

	@Override
	public void eliminar(long id) {
		ipersona.deleteById(id);
		System.out.println("La persona fue eliminada.");
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<PersonaTesteada> listarPersonasTesteadas() {
		// TODO Auto-generated method stub
		return ipersona.findAll();
	}

	@Override
	public Optional<PersonaTesteada> listarPersonaId(long id) {
		
		return ipersona.findById(id);
	}
	


}
