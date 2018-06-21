package fworks.algorithms.sorting.mergesort;

import fworks.algorithms.sorting.SortingService;

/**
 * Mergesort service.
 * 
 * @author flaviolcastro
 *
 */
public interface MergesortService extends SortingService {

  public static final String MERGESORT = "Mergesort";

  @Override
  default String getAlgorithmName() {
    return MERGESORT;
  }
}
