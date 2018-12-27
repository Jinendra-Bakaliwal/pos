package com.jan.enterprise.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication 
public class PosApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	
	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PosApplication.class);
	}

}
