package fworks.algorithms.sorting.bubblesort;

import fworks.algorithms.sorting.SortingService;

/**
 * Bubblesort service.
 * 
 * @author flaviolcastro
 *
 */
public interface BubblesortService extends SortingService {

  public static final String BUBBLESORT = "Bubblesort";

  @Override
  default String getAlgorithmName() {
    return BUBBLESORT;
  }
}
