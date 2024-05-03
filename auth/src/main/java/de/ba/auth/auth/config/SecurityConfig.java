package de.ba.auth.auth.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	AuthenticationEventPublisher authenticationEventPublisher
	        (ApplicationEventPublisher applicationEventPublisher) {
	    return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
	}
	
    // User Creation 
    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) { 
  
        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder().encode("pass"))
                .roles("USER")
                .build();
            UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder().encode("pass"))
                .roles("USER")
                .build();
            UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("pass"))
                .roles("ADMIN")
                .build();
            return new InMemoryUserDetailsManager(user1, user2, admin);
    }

    // Configuring HttpSecurity 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
/*        return http
        		.cors( cors -> cors.disable() )
        		.authorizeHttpRequests(authz -> authz
        				  .requestMatchers("/**").authenticated() 
        				  .requestMatchers("/app/logout").permitAll()
        				  .anyRequest().authenticated()
        				  )
        		.formLogin(form -> form
//        				.loginPage("/login")
        				.permitAll()
        			)
    	    	.exceptionHandling( exceptionHandling -> exceptionHandling
    	    			.accessDeniedPage( "/denied" )
    	    			)
    	    	.logout( (logout) -> logout
    	                .logoutSuccessUrl( "/app/logout" )
    	                .invalidateHttpSession(true)
    	                .permitAll()
    	                .deleteCookies()
    	                )
                .httpBasic(Customizer.withDefaults()).build();*/

		http
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/", "/index", "/logout").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin((form) -> form
						.loginPage("/login")
						.permitAll()
				)
                .exceptionHandling( exceptionHandling -> exceptionHandling
                        .accessDeniedPage( "/denied" )
                )
				.logout((logout) -> logout
                        .invalidateHttpSession(true)
                        .permitAll()
                        .deleteCookies());

		return http.build();
    }    
    
    // Password Encoding 
    @Bean
    PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    } 
  
} 