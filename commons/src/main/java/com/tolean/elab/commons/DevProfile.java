package com.tolean.elab.commons;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Tomasz Kołodziej
 */
@Profile("dev")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DevProfile {

}
