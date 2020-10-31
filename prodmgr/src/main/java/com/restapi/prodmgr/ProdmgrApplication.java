package com.restapi.prodmgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProdmgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdmgrApplication.class, args);
	}

}
