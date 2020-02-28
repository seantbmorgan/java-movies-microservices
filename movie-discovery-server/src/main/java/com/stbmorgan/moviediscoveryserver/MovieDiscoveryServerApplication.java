package com.stbmorgan.moviediscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MovieDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDiscoveryServerApplication.class, args);
	}

}
