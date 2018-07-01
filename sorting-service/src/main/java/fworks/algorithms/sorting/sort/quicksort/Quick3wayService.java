package fworks.algorithms.sorting.sort.quicksort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Quick3way sorting service.
 * 
 * @author flaviolcastro
 *
 */
public interface Quick3wayService extends AlgorithmSortService {

  public static final String QUICK3WAY = "Quick3way";

  @Override
  default String getAlgorithmName() {
    return QUICK3WAY;
  }
  
}
