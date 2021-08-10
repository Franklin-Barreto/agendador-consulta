package br.com.santander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AgendadorConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorConsultaApplication.class, args);
	}

}
