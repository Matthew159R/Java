/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testespring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author salomao pc
 */

@SpringBootApplication
public class TesteSpring {

    public static void main(String[] args) {
        SpringApplication.run(TesteSpring.class, args);
        
    }
}

@RestController
class ApiController 
{
    @GetMapping("/api/data")
    public String getData ()
    {
        ConnectionToDatabase connection = new ConnectionToDatabase();
        connection.ConnectionRun();
        String jsonResult = connection.returnValues();
        
        return jsonResult;
    }
}

@Configuration
class CorsConfig 
{
    @Bean
    public CorsFilter corsFilter()
    {   
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://127.0.0.1:5500");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);      
    }
}

