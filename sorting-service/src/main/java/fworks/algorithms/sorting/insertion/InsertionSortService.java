package fworks.algorithms.sorting.insertion;

import fworks.algorithms.sorting.SortingService;

/**
 * Insertion sort service.
 * 
 * @author flaviolcastro
 *
 */
public interface InsertionSortService extends SortingService {

  public static final String INSERTION_SORT = "InsertionSort";

  @Override
  default String getAlgorithmName() {
    return INSERTION_SORT;
  }
}
