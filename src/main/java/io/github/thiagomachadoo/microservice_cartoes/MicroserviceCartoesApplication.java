package io.github.thiagomachadoo.microservice_cartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCartoesApplication.class, args);
	}

}
