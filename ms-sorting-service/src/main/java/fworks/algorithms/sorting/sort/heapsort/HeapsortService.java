package fworks.algorithms.sorting.sort.heapsort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Heapsort service.
 * 
 * @author flaviolcastro
 *
 */
public interface HeapsortService extends AlgorithmSortService {

  public static final String HEAPSORT = "Heapsort";

  @Override
  default String getAlgorithmName() {
    return HEAPSORT;
  }
}
