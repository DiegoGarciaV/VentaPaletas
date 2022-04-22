package com.dinobotica.paletas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PaletasApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PaletasApplication.class, args);
		System.out.println("Aplicacion en linea");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PaletasApplication.class);
    }
}
