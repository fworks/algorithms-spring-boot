package fworks.algorithms.sorting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortingRequest {

  /**
   * Key to be found.
   */
  private long key;
  
  /**
   * Array to be searched.
   */
  private long[] array;

}
