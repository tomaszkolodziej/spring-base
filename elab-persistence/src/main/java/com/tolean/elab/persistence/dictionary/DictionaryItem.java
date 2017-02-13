package com.tolean.elab.persistence.dictionary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Tomasz Kołodziej <tomasz.kolodziej@coi.gov.pl>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_item_gen")
  @SequenceGenerator(name = "dictionary_item_gen", sequenceName = "dictionary_item_id_seq")
  private Long id;

  private String name;
  private boolean active = true;

}
