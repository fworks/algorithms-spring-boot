package fworks.algorithms.sorting.sort.bubblesort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Bubblesort service.
 * 
 * @author flaviolcastro
 *
 */
public interface BubblesortService extends AlgorithmSortService {

  public static final String BUBBLESORT = "Bubblesort";

  @Override
  default String getAlgorithmName() {
    return BUBBLESORT;
  }
}
