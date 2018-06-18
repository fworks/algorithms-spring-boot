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
   * Sorted array response
   */
  private long[] sortedArray;
  
  /**
   * Number of positions exchanging during the sorting. 
   */
  private long numberOfExchanges;
  
  /**
   * Duration of the sorting in ms. 
   */
  private Duration duration;
  
}
