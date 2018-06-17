package fworks.algorithms.sorting;

import java.time.Duration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortingResponse {

  /**
   * Algorithm name.
   */
  private String algorithm;
  
  /**
   * Size of the search array.
   */
  private long arraySize;
  
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
  private Duration duration;
  
}
