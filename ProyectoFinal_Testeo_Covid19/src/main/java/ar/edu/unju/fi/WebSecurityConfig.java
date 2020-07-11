package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ar.edu.unju.fi.service.LoginUsuarioServiceImp;

/**
 * Configuracion de las opciones por defecto al extender WebSecurityConfigurerAdapter
 *  Se define que acciones se puede permitir para cada usuario..
 * 
 * @author Uzqueda,Jose G.
 *
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	//Se inyecta la clase AutenticacionSuccessHandler , redirecciona cada usuario segun su rol
	@Autowired
	private AutenticacionSuccessHandler autenticacion;
	
	//Recursps que tiene el proyecto
	String [] resources = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
	};
	
	//Sobreescribimos el metodo configure
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
			.authorizeRequests()
			//Tienen permisos de los recursos 
				.antMatchers(resources).permitAll()
				//Todos los usuarios tiene permiso para ir a /login
				.antMatchers("/login").permitAll()
				
				//Paginas autorizadas segun el rol
				
				.antMatchers("/usuarioBM").hasAuthority("BD")
				.antMatchers("/registroUsuario").hasAuthority("BD")
				
				.antMatchers("/registrarUnidad").hasAuthority("REGISTRADOR")
				.antMatchers("/registroBarrio").hasAuthority("REGISTRADOR")
				.antMatchers("/formularioPersona").hasAuthority("REGISTRADOR")
				
				.antMatchers("/consulta").hasAuthority("CONSULTOR")
				.antMatchers("/consultaApellido").hasAuthority("CONSULTOR")
				.antMatchers("/consultaBarrio").hasAuthority("CONSULTOR")
				.antMatchers("/consultaDNI").hasAuthority("CONSULTOR")
				.antMatchers("/seleccionarUnidad").hasAuthority("CONSULTOR")
				
				//En caso de requerir otra cosa, se pedira autenticacion
				.anyRequest().authenticated()
				.and()
				//Configuracion de la pagina de logueo
			.formLogin()
			//Todos tiene permiso, el login se encuentra en /inicio
				.loginPage("/login")
				.permitAll()
				
				//Al ingresar se direccionara segun el rol del usuario
				.successHandler(autenticacion) 
				//Pagina donde redireccionara cuando el logeo sea invalido
				.failureUrl("/inicio?error=true")
				//Paramentros del usuario para login 
				.usernameParameter("usuario")
				.usernameParameter("password")
				.and()
				
				//Configuracion del logout
			.logout()
			//Todos tiene permiso a logout
				.permitAll()
				//Permiso para establecer una pagina para redirigir en logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

	}
				

	//Encriptacion de la contraseña
	BCryptPasswordEncoder bCrypyPasswordEncoder;
	
	//Metodo para definir el nivel de encriptado
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCrypyPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCrypyPasswordEncoder;
	}
	
	//Autentica al usuario
	@Autowired
	LoginUsuarioServiceImp userDetailsService;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
	
	
}
