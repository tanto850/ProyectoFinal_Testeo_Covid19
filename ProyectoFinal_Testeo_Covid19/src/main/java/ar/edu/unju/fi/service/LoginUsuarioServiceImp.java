package ar.edu.unju.fi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.repository.IUsuarioRepository;
import ar.edu.unju.fi.testeos.model.Usuario;

/**
 * Servicio especial que implementa la interfaz UserDetailsService de spring security que guarda el usuario con el que va a trabajar para su autenticacion
 * Permite 3 acciones : verificar/autenticar el usuario; redirigir/mostrar segun el tipo de usuario; Encriptacion de clave de usuario
 * 
 */

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {
	
	/**
	 * Inyeccion de la interfaz repository del Usuario
	 */
	@Autowired
	IUsuarioRepository iUsuario;
	
	private Logger log = Logger.getLogger("");
	
	/**
	 * Se sobre escribe el metodo UserDetailService pasandole: nombre del usuario, una contraseña y una lista de autorizacion(roles) 
	 * 
	 * @param Recibe un nombre de Usuario.
	 * 
	 * @return Devuelve un UserDetails, es de Spring Security 
	 */

	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {

		
		// Busca al Usuario por el su nombre legueado en caso de no encontrarlo mostrar el mensaje Login Invalido..
		
		Usuario usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario).orElseThrow(()-> new UsernameNotFoundException("Login Invalido") );
		
		//Esta guardando la coleccion de roles que tienen los usuarios
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		
		log.info(usuarioEncontrado.getTipoUsuario());
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);
		
		//Declaro el objeto UserDetails que retornara el metodo, trabaja con ciertos datos del usuario que se pasaran como parametros, nombre de usuario-contraseña del usuario-rol

		UserDetails user = (UserDetails) new User(nombreUsuario, usuarioEncontrado.getPassword(),tipos);
		log.info(user.getPassword() + user.getUsername());
		
		return user;
	}
	
}
