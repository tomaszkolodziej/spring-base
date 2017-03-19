package com.tolean.elab.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by tomasz.kolodziej@poczta.pl
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableMongoRepositories
@EntityScan
public class ElabPersistenceConfiguration {

}
