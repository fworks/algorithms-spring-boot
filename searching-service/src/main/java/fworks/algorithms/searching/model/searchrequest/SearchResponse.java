package fworks.algorithms.searching.model.searchrequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Search Response model.
 * 
 * @author flaviolcastro
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SearchResponse {

  /**
   * Generated id.
   */
  @Id
  @GeneratedValue
  private Long id;

  /**
   * Algorithm name.
   */
  @Column(nullable = false)
  private String algorithm;

  /**
   * Size of the search array.
   */
  @Column(nullable = false)
  private long arraySize;

  /**
   * Index position of the key. It will be -1 if not found.
   */
  @Column(name = "search_index", nullable = false)
  private int index;

  /**
   * Number of keys analysed during the search.
   */
  @Column(nullable = false)
  private long numberOfKeysAnalized;

  /**
   * Duration of the search in seconds.
   */
  @Column(nullable = false)
  private double duration;

}
