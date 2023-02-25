package com.config.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer /* This annotation used to enable ConfigServer */
public class ConfigurationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceApplication.class, args);
	}

}
