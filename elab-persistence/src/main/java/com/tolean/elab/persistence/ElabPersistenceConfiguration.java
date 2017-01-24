package com.tolean.elab.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan
public class ElabPersistenceConfiguration {

}
