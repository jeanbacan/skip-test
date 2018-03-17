package com.skip.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.skip.service.filter.TokenAuthenticationFilter;

/**
 * Authentication initializer
 * 
 * @author Note-Chronos
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JWTAuthConfig extends WebSecurityConfigurerAdapter {

	//For jwt 
	// https://github.com/bfwg/angular-spring-starter/
	
	/*@Autowired
	private CustomUserDetailsService jwtUserDetailsService;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private LogoutSuccess logoutSuccess;*/
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Bean
	public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
		return new TokenAuthenticationFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		//authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().ignoringAntMatchers("/api/v1/login")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class).authorizeRequests()
				.anyRequest().authenticated().and().formLogin().loginPage("/api/login")
				.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/logout"))
				.logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);*/

	}
}
