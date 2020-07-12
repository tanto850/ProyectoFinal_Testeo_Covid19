package ar.edu.unju.fi.service;

import java.util.ArrayList;
import java.util.List;

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
 * @author Uzqueda, Jose G.
 *
 */

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {
	
	@Autowired
	IUsuarioRepository iUsuario;

	//Se sobre escribe el metodo UserDetailService
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// Busca al Usuario por el su nombre legueado en caso de no encontrarlo mostrar el mensaje Login Invalido..
		
		Usuario usuarioEncontrado = iUsuario.findByNombreUsuario(nombreUsuario).orElseThrow(()-> new UsernameNotFoundException("Login Invalido") );
		
		//Esta guardando la coleccion de roles que tienen los usuarios
		List<GrantedAuthority> tipos = new ArrayList<>();
		
		System.out.println(usuarioEncontrado.getTipoUsuario());
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);
		
		//Declaro el objeto UserDetails que retornara el metodo, trabaja con ciertos datos del usuario que se pasaran como parametros

		UserDetails user = (UserDetails) new User(nombreUsuario, usuarioEncontrado.getPassword(),tipos);
		System.out.println(user.getPassword() + user.getUsername());
		
		return user;
	}
	
}
