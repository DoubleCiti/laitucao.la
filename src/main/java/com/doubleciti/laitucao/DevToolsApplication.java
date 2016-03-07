package com.doubleciti.laitucao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

@SpringBootApplication
public class DevToolsApplication extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {
	public static void main(String[] args) {
		SpringApplication.run(DevToolsApplication.class, args);
	}
}
