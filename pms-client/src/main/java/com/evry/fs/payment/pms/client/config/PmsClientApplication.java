package com.evry.fs.payment.pms.client.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@ComponentScan(basePackages = "com.evry.fs.payment.pms.client")
public class PmsClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsClientApplication.class, args);
	}
	
	@Bean
	public ModelAndView getModel() {
		return new ModelAndView();
	}

}
