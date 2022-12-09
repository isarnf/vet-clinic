package br.edu.ifsp.aluno.vetclinic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.edu.ifsp.aluno.config.SecurityConfiguration;

@SpringBootApplication
@Import({ SecurityConfiguration.class })
public class VetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetClinicApplication.class, args);
	}

}
