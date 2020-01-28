package com.joseluisestevez.msa.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServiceProductsApplication {

	public static void main(String[] args) {
		// run with environment -Dserver.port=9001
		SpringApplication.run(SpringbootServiceProductsApplication.class, args);
	}

}
