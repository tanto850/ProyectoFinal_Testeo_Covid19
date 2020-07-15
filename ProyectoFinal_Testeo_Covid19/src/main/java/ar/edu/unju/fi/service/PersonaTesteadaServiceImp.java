/**
 * 
 */
package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IPersonaTesteadaRepository;
import ar.edu.unju.fi.testeos.model.PersonaTesteada;
import ar.edu.unju.fi.testeos.model.RegistroTesteo;

/**
 * implementacion de las personasTesteadas, metodos del IPersonaTesteadaService
 */
@Service
public class PersonaTesteadaServiceImp implements IPersonaTesteadaService{
	
	@Autowired
	public IPersonaTesteadaRepository ipersona;
	
	private Logger log = Logger.getLogger("");

	@Override
	public void guardar(PersonaTesteada personaTesteada) {
		ipersona.save(personaTesteada);
		log.info("La persona de apellido "+ personaTesteada.getApellido()+ " ha sido resgistrada en la base de datos.");
	}

	@Override
	public void eliminar(long id) {
		ipersona.deleteById(id);
		log.info("La persona fue eliminada.");
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

	@Override
	public List<PersonaTesteada> listarPersonaApellido(String apellido) {
		// TODO Auto-generated method stub
		return ipersona.findByApellidoContaining(apellido);
	}

	@Override
	public List<PersonaTesteada> listarPersonaDocumento(String dni) {
		// TODO Auto-generated method stub
		return ipersona.findByDocumentoContaining(dni);
	}


	@Override
	public List<PersonaTesteada> listarBarrioFechas(String barrio, LocalDateTime fecha1, LocalDateTime fecha2) {
		// TODO Auto-generated method stub
		return ipersona.findByRegistroTesteoUnidadHabitacionalBarrioNombreAndRegistroTesteoFechaHoraBetweenOrderByRegistroTesteoUnidadHabitacionalDireccion(barrio, fecha1, fecha2);
	}

	@Override
	public Iterable<PersonaTesteada> listarPersonasTesteadasRegistro(RegistroTesteo registroTesteo) {
		// TODO Auto-generated method stub
		return ipersona.findByRegistroTesteo(registroTesteo);
	}

	@Override
	public List<PersonaTesteada> listarPersonas() {
		// TODO Auto-generated method stub
		return ipersona.findAll();
	}

	@Override
	public boolean encontrarPersonaRegistro(PersonaTesteada unaPersonaTesteada) {
		// TODO Auto-generated method stub
		Optional<PersonaTesteada> personaBuscada = ipersona.findByDocumentoAndRegistroTesteo(unaPersonaTesteada.getRegistroTesteo(), unaPersonaTesteada.getDocumento());
		return personaBuscada.isPresent();
	}


}
