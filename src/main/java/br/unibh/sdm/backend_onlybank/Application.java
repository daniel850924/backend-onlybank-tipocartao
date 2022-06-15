package br.unibh.sdm.backend_onlybank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe executável que inicia a aplicação Spring Boot
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.unibh.sdm.backend_onlybank.persistencia")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		log.info("Inicializando...");
	    System.setProperty("server.servlet.context-path", "/tipocartao-api");
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}
