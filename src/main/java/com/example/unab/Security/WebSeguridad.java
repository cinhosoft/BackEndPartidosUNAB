/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unab.Security;
import java.time.Duration;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSeguridad extends WebSecurityConfigurerAdapter {
  @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    @Qualifier("usuarioServicio")
    private UserDetailsService usuarioServicio;
  
    private static final Log logger = LogFactory.getLog(WebSeguridad.class);
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Arrays.asList("Origin.Accept", "X-Requested-Widh", "Content-Type", "Access-Control-Request-Method","Access-Control-Allow-Headers","Authorization"));
        configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin","Access-Control-Allow-Credentials,Authorization,FADY"));
            //"Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));
        
        configuration.setAllowedOrigins(Arrays.asList("*"));
        
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","OPTIONS"));
        configuration.addAllowedOrigin("*");
        configuration.setMaxAge(Duration.ZERO);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioServicio);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf().disable().authorizeRequests()
                .antMatchers("/*","/login", "/usuario/agregar", "/swagger-resources", "/swagger-ui.html", "/swagger-ui/", "/swagger-ui/#/usuario", "/v2/api-docs").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
}