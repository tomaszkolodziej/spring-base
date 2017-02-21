package com.tolean.elab.persistence.dictionary;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.util.List;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Entity
@Data
public class Dictionary {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_gen")
  @SequenceGenerator(name = "dictionary_gen", sequenceName = "dictionary_id_seq")
  private Long id;

  private String code;
  private String name;
  private String description;
  private boolean active;

  @OneToOne
  @JoinColumn(name = "default_item_id")
  private DictionaryItem defaultValue;

  @OneToMany
  @JoinColumn(name = "dictionary_id")
  private List<DictionaryItem> dictionaryItems;

}
