package fr.aoufi.springrestclient.conf;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.aoufi.springrestclient.dao.PersonneDAO;
import fr.aoufi.springrestclient.dao.PersonneJDBCDAO;
import fr.aoufi.springrestclient.dao.PersonneJPADAO;
import fr.aoufi.springrestclient.service.PersonneService;
import fr.aoufi.springrestclient.service.PersonneServiceImpl;

 
@Configuration 
@Import(value = { DataConfiguration.class })
@ComponentScan(basePackages={"fr.aoufi.springrestclient.service"})
@PropertySource(value = "classpath:/config.properties")  
public class ApplicationConfiguration {
	
	@PersistenceContext
	private EntityManager em;
	
	@Bean 
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(initMethod="init", destroyMethod="destroy")
	public PersonneService personneService(PersonneDAO personneDAO) {
		PersonneServiceImpl personneService = new PersonneServiceImpl();
		personneService.setPersonneDAO(personneDAO);
		return personneService;
	}

	@Bean(name = "personneDAO") 
	@Profile("jpa")  
	public PersonneDAO personneJPADAO() {
		PersonneJPADAO personneJPADAO = new PersonneJPADAO();
		personneJPADAO.setEm(em);
		return personneJPADAO;
	}

	@Bean(name = "personneDAO")
	@Profile("jdbc")  
	public PersonneDAO personneJDBCDAO() {
		return new PersonneJDBCDAO();
	}

}