package br.com.fiap.healthtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
//@EnableSwagger2
public class HealthTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthTrackApplication.class, args);
	}

}
