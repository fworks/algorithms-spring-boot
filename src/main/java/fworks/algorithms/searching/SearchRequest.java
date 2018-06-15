package fworks.algorithms.searching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

  /**
   * Key to be found.
   */
  private long key;
  
  /**
   * Array to be searched.
   */
  private long[] array;

}
