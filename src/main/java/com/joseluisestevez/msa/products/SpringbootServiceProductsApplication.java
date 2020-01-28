package com.joseluisestevez.msa.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootServiceProductsApplication {

	public static void main(String[] args) {
		// run with environment -Dserver.port=9001
		SpringApplication.run(SpringbootServiceProductsApplication.class, args);
	}

}
