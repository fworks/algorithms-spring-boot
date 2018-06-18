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
   * Array to be sorted.
   */
  private long[] array;

}
