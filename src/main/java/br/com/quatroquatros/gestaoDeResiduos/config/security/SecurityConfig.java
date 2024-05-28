package br.com.quatroquatros.gestaoDeResiduos.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private br.com.quatroquatros.gestaoDeResiduos.config.security.VerifyToken verifyToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(
            HttpSecurity httpSecurity) throws Exception{

        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "api/teste").permitAll()

                        //Bairros
                        .requestMatchers(HttpMethod.GET, "api/bairros").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/bairros/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/bairros/maisLixo").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/bairros").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/bairros/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/bairros/{id}").hasRole("ADMIN")

                        //Coletas
                        .requestMatchers(HttpMethod.GET, "api/coletas").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/coletas/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/coletas/agendamentos").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/coletas/agendar").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.PUT, "/api/coletas/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/coletas/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/coletas/{coletaId}/concluir").hasRole("ADMIN")

                        //Estados
                        .requestMatchers(HttpMethod.GET, "api/estados").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/estados/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/api/uf/{uf}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/estados/maisLixo").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/estados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/estados/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/estados/{id}").hasRole("ADMIN")

                        //Lixo Coletado
                        .requestMatchers(HttpMethod.GET, "api/lixoColetado").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/lixoColetado/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/lixoColetado").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/lixoColetado/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/lixoColetado/{id}").hasRole("ADMIN")

                        //Regioes
                        .requestMatchers(HttpMethod.GET, "api/regioes").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/regioes/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/regioes/maisLixo").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/regioes").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/regioes/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/regioes/{id}").hasRole("ADMIN")

                        //Ruas
                        .requestMatchers(HttpMethod.GET, "api/ruas").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/ruas/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/ruas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/ruas/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/ruas/{id}").hasRole("ADMIN")

                        //Tipos Coletas
                        .requestMatchers(HttpMethod.GET, "api/tipoColetas").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "api/tipoColetas/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "api/tipoColetas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/tipoColetas/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/tipoColetas/{id}").hasRole("ADMIN")

                        //Usuarios
                        .requestMatchers(HttpMethod.GET, "api/usuarios").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "api/usuarios/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "api/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/usuarios/{id}").hasAnyRole("ADMIN", "USER")


                        .anyRequest()
                        .authenticated())
                .addFilterBefore(
                        verifyToken, UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }




    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
