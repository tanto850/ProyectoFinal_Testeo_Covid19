/**
 * 
 */
package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
//import java.time.LocalDate;
//import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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

private Logger log = Logger.getLogger("");

@Override
	public void guardar(RegistroTesteo registroTesteo) {
		// TODO Auto-generated method stub
		iRegistro.save(registroTesteo);
		log.info("El registro fue guardado con id" + registroTesteo.getId());
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		iRegistro.deleteById(id);
		log.info("El registro fue borrado.");
	}

	@Override
	public Optional<RegistroTesteo> mostrar(long id) {
		// TODO Auto-generated method stub
		
		return iRegistro.findById(id);
	}
	
	@Override
	public RegistroTesteo encontrarRegistroTesteo(LocalDateTime fechaHora) {
		
		return iRegistro.findByFechaHora(fechaHora);
	}

	

}
