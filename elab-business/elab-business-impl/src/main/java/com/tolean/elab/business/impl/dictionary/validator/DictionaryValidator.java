package com.tolean.elab.business.impl.dictionary.validator;

import com.tolean.elab.persistence.dictionary.Dictionary;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by admin on 06.02.2017.
 */
@Component
public class DictionaryValidator {

  public void check(Dictionary dictionary){
    checkNotNull("20170206:1906", dictionary);

  }
}
