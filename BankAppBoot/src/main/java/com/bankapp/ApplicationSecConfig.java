package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationSecConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService detailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().

				authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
				.and().httpBasic();
	}

	
	  @Autowired 
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication()
	  .withUser("kavya").password("{noop}kavya123").roles("USER"); }
	  
	 

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.userDetailsService(detailService);
	 * 
	 * }
	 */

	/*
	 * @Bean public PasswordEncoder getEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { //
	 * TODO Auto-generated method stub http.csrf().disable() .authorizeRequests()
	 * 
	 * 
	 * .antMatchers("/account/**").hasAnyRole("MGR","EMP")
	 * .antMatchers("/home/**").permitAll()
	 * 
	 * .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
	 * STATELESS); }
	 */
}
