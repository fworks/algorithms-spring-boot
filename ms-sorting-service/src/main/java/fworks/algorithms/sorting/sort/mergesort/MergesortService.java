package fworks.algorithms.sorting.sort.mergesort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Mergesort service.
 * 
 * @author flaviolcastro
 *
 */
public interface MergesortService extends AlgorithmSortService {

  public static final String MERGESORT = "Mergesort";

  @Override
  default String getAlgorithmName() {
    return MERGESORT;
  }
}
