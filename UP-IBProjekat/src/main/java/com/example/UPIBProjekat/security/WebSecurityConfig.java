package com.example.UPIBProjekat.security;

import javax.ws.rs.HttpMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private UserDetailsServiceImpl myUserDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}
	

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			
//			.antMatchers("/klinike").hasAnyAuthority("LEKAR")
			.antMatchers("/pregledi").permitAll()
			.antMatchers("/pregledi/**").permitAll()
			.antMatchers("/doktori/**").permitAll()
			.antMatchers("/doktori").permitAll()
			.antMatchers("/korisnici").permitAll()
			.antMatchers("/korisnici/**").permitAll()
			.antMatchers("/korisnik/**").permitAll()

			.antMatchers("/pacijenti/**").permitAll()
			.antMatchers("/role").permitAll()

			.antMatchers("/adminiKlinike").permitAll()
			.antMatchers("/medicinskesestre/**").permitAll()



			//.antMatchers("/korisnici").hasAnyAuthority("LEKAR")
			.antMatchers(HttpMethod.DELETE,"/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/pregledi/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/klinike").hasRole("PACIJENT")

//			.antMatchers("/api/test/**").permitAll()
//			.antMatchers("/api/articles").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}
