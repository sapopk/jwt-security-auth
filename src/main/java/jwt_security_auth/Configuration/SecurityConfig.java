package jwt_security_auth.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .securityContext(securityContext -> securityContext.requireExplicitSave(false))
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsConfig -> corsConfig.disable())
                .csrf(csrfConfig -> csrfConfig.disable())
                .requiresChannel(requires -> requires.anyRequest().requiresInsecure())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/public/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(login -> login.disable());

        return http.build();
    }
}