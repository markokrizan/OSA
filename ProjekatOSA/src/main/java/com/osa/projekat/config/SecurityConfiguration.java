package com.osa.projekat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.osa.projekat.repository.UserRepository;
import com.osa.projekat.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
//enables spring security
@EnableWebSecurity
//mozda ovde ceo paket mora? mozda i ne mora
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//ovo je servise koje se prosledjuje i koji pruza informacije o korisnicima koje dobija iz baze
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//ovde se biraju tipovi autentikacije, moze svasta, ovo je tip pomocu servisa koji ce se kaciti na bazu 
		//i odatle vaditi kredencijale
		
		//moguce odraditi hesiranje passworda, trenutno ne
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
			
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		//http.csrf().disable();//ovo ovako treba da bude
		http.csrf();
		http.authorizeRequests()
				//autentifikuj sve koji gadjaju uri koji negde ima news-api
				.antMatchers("**/news-api/**").authenticated()
				.anyRequest().permitAll()
				.and()
				//custom login page:
				//.formLogin().loginPage("/loginpage")
				.formLogin()
				.permitAll();
		
		
	}
	
	
	
	
	
	
	

}
