package org.techtalk.debu.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"org.techtalk.debu.spring.config","org.techtalk.debu.spring.jpa.controller","org.techtalk.debu.spring.jpa.service.impl"})
public class SpringBootDataJPATestApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJPATestApp.class, args);
	}

}
