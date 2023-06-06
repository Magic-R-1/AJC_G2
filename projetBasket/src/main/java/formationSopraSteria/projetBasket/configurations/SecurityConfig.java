package formationSopraSteria.projetBasket.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
							.antMatchers("/api/compte/**").permitAll()
						//	.antMatchers(HttpMethod.POST,"/api/compte/**").anonymous()
						//	.antMatchers(HttpMethod.GET,"/api/compte/**").anonymous()
							.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
							.antMatchers("/api/equipe/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/joueur/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/confrontation/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/stade/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/reservation/**").hasAnyRole("ADMIN","CLIENT","GM")
							.antMatchers("/api/personnel/**").hasAnyRole("ADMIN","GM")
//							.antMatchers("/api/compte/**").hasAnyRole("ADMIN","GM","CLIENT")
							.anyRequest().hasAnyRole("ADMIN")

							//.anyRequest().permitAll()

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
