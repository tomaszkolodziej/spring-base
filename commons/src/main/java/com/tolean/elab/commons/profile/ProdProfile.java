package com.tolean.elab.commons.profile;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tomasz Kołodziej
 */
@Profile("prod")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProdProfile {

}
