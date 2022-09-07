package br.edu.ufape.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;

@SpringBootApplication
public class WhrVeiculosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appCtx =  SpringApplication.run(WhrVeiculosApplication.class, args);
	}

}
