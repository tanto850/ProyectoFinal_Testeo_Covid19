package ar.edu.unju.fi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import ar.edu.unju.fi.testeos.model.RegistroTesteo;
/**
 * 
 * Se definen los metodos que tendremos que implementar sobre la clase RegistroTesteo
 */
public interface IRegistroTesteoService {
	public void guardar(RegistroTesteo resgistroTesteo);
	public void eliminar(long id);
	public Optional<RegistroTesteo> mostrar(long id);
	public RegistroTesteo encontrarRegistroTesteo(LocalDateTime fechaHora);
}
