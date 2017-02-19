package com.tolean.elab.persistence.dictionary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

import static pl.wavesoftware.eid.utils.EidPreconditions.checkNotNull;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dictionary {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_gen")
  @SequenceGenerator(name = "dictionary_gen", sequenceName = "dictionary_id_seq")
  private Long id;

  private String code;
  private String name;
  private String description;
  private boolean active;

  @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinColumn(name = "dictionary_id")
  private List<DictionaryItem> dictionaryItems;

  public DictionaryItem getDictionaryItem(Long id) {
    checkNotNull(id, "20170212:162904");

    DictionaryItem dictionaryItem = null;

    for (DictionaryItem item : dictionaryItems) {
      if (item.getId().equals(id)) {
        dictionaryItem = item;
        break;
      }
    }

    return dictionaryItem;

  }

}
