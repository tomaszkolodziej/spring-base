package com.tolean.elab.presentation.rest;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@RestController
@RequestMapping(value = "/dictionary")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryRestController {

  private final DictionaryService dictionaryService;

  @RequestMapping(method = RequestMethod.GET)
  public DictionaryViewDto getDictionary(@RequestParam String code) {
    checkNotNull("20170131:1536", code);

    return dictionaryService.getDictionaries(code);
  }

}
