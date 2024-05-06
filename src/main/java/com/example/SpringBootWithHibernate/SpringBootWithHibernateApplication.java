package com.example.SpringBootWithHibernate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
 

@SpringBootApplication
public class SpringBootWithHibernateApplication {
    @Autowired
	DataSource ds;
    
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithHibernateApplication.class, args);
	}
	@Bean(name = "entityManagerFactory")
    public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(ds);
		sf.setAnnotatedClasses(Bird.class);
		return sf;

	}
}
