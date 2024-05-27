package br.com.quatroquatros.gestaoDeResiduos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.quatroquatros.gestaoDeResiduos")

public class GestaoDeResiduosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeResiduosApplication.class, args);
	}

}
