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
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
		
	/**
	 * Se inyecta la clase AutenticacionSuccessHandler , redirecciona cada usuario segun su rol
	 */
	@Autowired
	private AutenticacionSuccessHandler autenticacion;
	
	/**
	 * Recursps que tiene el proyecto
	 * @param Recibe una peticion de tipo HTTP que sera evaluada por el Authenticacion Manager
	 */
	String [] resources = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
	};
	
	/**
	 * Sobreescribimos el metodo configure
	 */
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
				.antMatchers("/registroBarrio").hasAuthority("BD")
				
				.antMatchers("/registrarUnidad").hasAuthority("REGISTRADOR")
				.antMatchers("/formularioPersona").hasAuthority("REGISTRADOR")
				.antMatchers("/seleccion").hasAuthority("REGISTRADOR")
				
				.antMatchers("/consulta").hasAuthority("CONSULTOR")
				.antMatchers("/consultaApellido").hasAuthority("CONSULTOR")
				.antMatchers("/consultaDNI").hasAuthority("CONSULTOR")
				.antMatchers("/hola").hasAuthority("CONSULTOR")

				
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
				.failureUrl("/login?error=true")
				
				//Paramentros del usuario para login 
				.usernameParameter("nombreUsuario")
				.passwordParameter("password")
				.and()
				
				//Configuracion del logout
			.logout()
			//Todos tiene permiso a logout
				.permitAll()
				//Permiso para establecer una pagina para redirigir en logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		//Permite redirigir los intentos de accesos denegados de los usuarios logueados..
		http.exceptionHandling().accessDeniedPage("/noAutorizado");
		
	//	http.csrf().disable();
	}
				


	//Encriptacion de la contraseña, variable que permite codificar la clave por metodo matematico. Pertenece a Spring Security
	BCryptPasswordEncoder bCrypyPasswordEncoder;
	
	/**
	 * Metodo para definir el nivel de encriptado de BCryptPasswordEncoder 
	 * @return Un nivel de encriptado de nivel 4(bajo)
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCrypyPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCrypyPasswordEncoder;
	}
	
	//Se inyecta LoginUsuarioServiceImp que autentica al usuario
	@Autowired
	LoginUsuarioServiceImp userDetailsService;
	
	/**
	 * Metodo que usa el AuthenticationManagerBuilder, recupera la informacion del usuario guardado.
	 * userDetailsService recuperara la informacion del usuario que quiere entrar y crea un usuario UserDetail
	 * Los datos recuperados son usados para la configuracion global
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());		
	}	
	
}
