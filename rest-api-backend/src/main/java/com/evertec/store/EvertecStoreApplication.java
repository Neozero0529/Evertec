package com.evertec.store;



import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.evertec.store"})
public class EvertecStoreApplication {	

    public static void main(String[] args) {
        SpringApplication.run(EvertecStoreApplication.class, args);
    }
    
    @Bean                 
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localResolver=new SessionLocaleResolver();
        localResolver.setDefaultLocale(new Locale("es", "ES"));
        return localResolver;
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
          = new ReloadableResourceBundleMessageSource();
        
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
}
