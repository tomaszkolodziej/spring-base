package com.tolean.elab.presentation.rest;

import com.tolean.elab.business.api.dictionary.DictionaryService;
import com.tolean.elab.dto.dictionary.DictionaryItemNewDto;
import com.tolean.elab.dto.dictionary.DictionaryItemUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryUpdateDto;
import com.tolean.elab.dto.dictionary.DictionaryViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return dictionaryService.getDictionary(code);
    }

    @RequestMapping(value = "/{code}/item", method = RequestMethod.POST)
    public DictionaryViewDto addDictionaryItem(@PathVariable String code, @RequestBody DictionaryItemNewDto dictionaryItemNewDto) {
        return dictionaryService.addDictionaryItem(code, dictionaryItemNewDto);
    }

    @RequestMapping(value = "/{code}/item/{itemId}", method = RequestMethod.PUT)
    public DictionaryViewDto updateDictionaryItem(@PathVariable String code, @PathVariable Long itemId,
                                                  @RequestBody DictionaryItemUpdateDto dictionaryItemUpdateDto) {
        return dictionaryService.updateDictionaryItem(code, itemId, dictionaryItemUpdateDto);
    }

    @RequestMapping(value = "/{code}/defaultValue", method = RequestMethod.PUT)
    public DictionaryViewDto update(@PathVariable String code, @RequestBody DictionaryUpdateDto dictionaryUpdateDto) {
        checkNotNull("20170221:1958", code);

        return dictionaryService.update(code, dictionaryUpdateDto);
    }
}
