package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"edu"})
public class MsubannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsubannerApplication.class, args);
	}
}
