package com.mycompany.invoise.invoice;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.mycompany.invoise.core.entity.invoice")
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean
	public Hibernate5Module datatypeHibernateModule() {
		Hibernate5Module module= new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		return module;
	}
}
