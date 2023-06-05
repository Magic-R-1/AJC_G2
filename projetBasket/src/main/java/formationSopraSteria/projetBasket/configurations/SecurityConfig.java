package formationSopraSteria.projetBasket.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// @formatter:off

		return http.antMatcher("/api/**")
						.csrf().disable()
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and()
						.authorizeRequests()
							.antMatchers(HttpMethod.OPTIONS).permitAll()
							.antMatchers(HttpMethod.POST,"/api/compte/inscription").anonymous()
							.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
//							.antMatchers("/api/StatutRole").hasRole("CLIENT")
							.antMatchers("/api/equipe/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/joueur/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/confrontation/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/stade/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/reservation/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/personnel/**").hasAnyRole("ADMIN","GM")
							.anyRequest().hasAnyRole("ADMIN")
						.and()
						.httpBasic()
						.and()
						.build();

		// @formatter:on
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
