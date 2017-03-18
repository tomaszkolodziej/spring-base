package com.tolean.elab;

import com.tolean.elab.persistence.ElabPersistenceConfiguration;
import com.tolean.elab.presentation.security.WebSecurityConfiguration;
import com.tolean.smssender.EnableSmsSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableSmsSender
@Import({ElabPersistenceConfiguration.class, WebSecurityConfiguration.class})
public class ElabApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElabApplication.class, args);
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
