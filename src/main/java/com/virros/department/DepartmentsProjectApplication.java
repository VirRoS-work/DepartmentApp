package com.virros.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class DepartmentsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentsProjectApplication.class, args);
	}

}
