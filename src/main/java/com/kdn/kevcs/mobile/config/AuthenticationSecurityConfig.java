package com.kdn.kevcs.mobile.config;


import com.kdn.kevcs.mobile.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.inject.Inject;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class AuthenticationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	private UserDetailsService userDetailsService;

	// @Inject
	// private CustomAuthenticationProvider customAuthenticationProvider;

	// @Value("${server.context-path}")
	// private String contextPath;

	@Override
	public void configure(WebSecurity web){
		web.ignoring().antMatchers("/webjars/**", "/css/**", "/js/**", "/images/**", "/fonts/**", "/*.html");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				// .antMatchers("/webjars/**").permitAll()
				.antMatchers("/user/login").permitAll()
				.antMatchers("/user/login-in-process").permitAll()
				.antMatchers("/user/logout").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().fullyAuthenticated()
			.and()
				.formLogin()
				.loginPage("/user/login")
				.loginProcessingUrl("/user/login-in-process")
				.failureUrl("/user/login?error")
				.defaultSuccessUrl("/admin/dashboard.html", true)
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout()
				.logoutUrl("/user/logout")
				.deleteCookies("remember-me")
				.logoutSuccessUrl("/user/login?logout")
			.and()
				.rememberMe();
		/*
		httpSecurity.authorizeRequests()
				.antMatchers("/user/login").permitAll()
				.antMatchers("/user/login-in-process").permitAll()
				.antMatchers("/my/**").hasRole("USER")
				// .antMatchers("/user/login**").permitAll()
				// .antMatchers("/user/login-in-process**").permitAll()
				.anyRequest().authenticated();

		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

		httpSecurity.formLogin()
				.loginPage("/user/login")
				.loginProcessingUrl("/user/login-in-process")
				.failureUrl("/user/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl(servletPath + "/admin/dashboard.html", true);

		httpSecurity.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/user/login?logout")
				.invalidateHttpSession(true);

		// RemeberMe
		// httpSecurity.rememberMe().key("kevcs#WC637E6D9C0A1I5K67082EQ23GH34347");

		httpSecurity.exceptionHandling().accessDeniedPage("/error/denied");
		// httpSecurity.sessionManagement().invalidSessionUrl("/error/session_expired");
		*/
	}

	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider).userDetailsService(userDetailsService);
	}
	*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Password encrypter for UserRepository service and user repository
		// auth.authenticationProvider()
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	// @Override
	// protected UserDetailsService userDetailsService() {
	// 	return userDetailsService;
	// }
}
