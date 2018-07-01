package fworks.algorithms.sorting.sort.quicksort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Quicksort service.
 * 
 * @author flaviolcastro
 *
 */
public interface QuicksortService extends AlgorithmSortService {

  public static final String QUICKSORT = "Quicksort";

  @Override
  default String getAlgorithmName() {
    return QUICKSORT;
  }
}
