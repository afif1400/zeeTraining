package com.zee.zee5app;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		
	ConfigurableApplicationContext applicationContext =	SpringApplication.run(Zee5appspringbootApplication.class, args);
	
	DataSource dataSource = applicationContext.getBean(DataSource.class);
	System.out.println(dataSource!=null);
	
	applicationContext.close();
	
	}

}
