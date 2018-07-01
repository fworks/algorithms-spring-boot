package fworks.algorithms.sorting.sort.insertion;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Insertion sort service.
 * 
 * @author flaviolcastro
 *
 */
public interface InsertionSortService extends AlgorithmSortService {

  public static final String INSERTION_SORT = "InsertionSort";

  @Override
  default String getAlgorithmName() {
    return INSERTION_SORT;
  }
}
