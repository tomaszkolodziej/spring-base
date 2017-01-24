package com.tolean.elab;

import com.tolean.elab.persistence.ElabPersistenceConfiguration;
import com.tolean.elab.presentation.security.WebSecurityConfiguration;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import({ElabPersistenceConfiguration.class, WebSecurityConfiguration.class})
public class ElabApplication {

  public static void main(String[] args) {
    SpringApplication.run(ElabApplication.class, args);
  }

  @Bean
  public PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer ();
    YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
    yamlPropertiesFactoryBean.setResources(new ClassPathResource("application.yml"));
    propertySourcesPlaceholderConfigurer.setProperties(yamlPropertiesFactoryBean.getObject());
    return propertySourcesPlaceholderConfigurer;
  }

}
