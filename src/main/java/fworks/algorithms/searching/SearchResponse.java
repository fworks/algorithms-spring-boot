package fworks.algorithms.searching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

  /**
   * Index position of the key. It will be -1 if not found.
   */
  private int index;
  
  /**
   * Number of keys analysed during the search. 
   */
  private long numberOfKeysAnalized;
  
  /**
   * Duration of the search in ms. 
   */
  private long durationMs;
  
}
