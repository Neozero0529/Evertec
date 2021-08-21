package com.evertec.store;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.evertec.store.persistence.entity.Order;
import com.evertec.store.persistence.repository.OrderRepository;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = { "com.evertec.store" })
public class EvertecStoreApplication {
	
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(EvertecStoreApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localResolver = new SessionLocaleResolver();
		localResolver.setDefaultLocale(new Locale("es", "ES"));
		return localResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	
	@PostConstruct
	public void test() {		
		 Order user = new Order();
		 user.setCustomerEmail("manuelosorio@usantotomas.edu.co"); 
		 user.setCustomerMobile("3212217567");
		 user.setStatus("rejected");
		 user.setCustomerName("manuel osorio"); 
		 user.setCreatedAt(new DateTime());
		 orderRepository.save(user);	
	}
}

