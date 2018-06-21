package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.SortingService;

/**
 * Quicksort service.
 * 
 * @author flaviolcastro
 *
 */
public interface QuicksortService extends SortingService {

  public static final String QUICKSORT = "Quicksort";

  @Override
  default String getAlgorithmName() {
    return QUICKSORT;
  }
}
