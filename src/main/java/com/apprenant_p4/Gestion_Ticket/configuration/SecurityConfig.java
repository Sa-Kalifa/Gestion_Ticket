package com.apprenant_p4.Gestion_Ticket.configuration;

import com.apprenant_p4.Gestion_Ticket.service.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailService userDetailService;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.userDetailsService(userDetailService);
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->  {
                    auth
                            .requestMatchers("/admin/**").permitAll()//hasRole("Admin")
                            .requestMatchers("/formateur/**").hasRole( "Formateur")
                            .requestMatchers("/apprenant/**").hasRole("Apprenant")

                            .anyRequest().authenticated();

                           /* .requestMatchers("utilisateur/**").hasRole("Admin")
                            .requestMatchers("ticket/**").hasAnyRole( "Formateur", "Apprenant")
                            .requestMatchers("ticket/reponse").hasRole("Formateur")
                            .requestMatchers("base/**").hasAnyRole("Admin", "Formateur", "Apprenant")
                            .anyRequest().authenticated(); */
                })
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}