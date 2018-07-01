package fworks.algorithms.sorting.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Sorting Input.
 * 
 * @author flaviolcastro
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortingInput {

  /**
   * Array to be sorted.
   */
  private long[] array;

}
