package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.SortingService;

/**
 * Quick3way sorting service.
 * 
 * @author flaviolcastro
 *
 */
public interface Quick3wayService extends SortingService {

  public static final String QUICK3WAY = "Quick3way";

  @Override
  default String getAlgorithmName() {
    return QUICK3WAY;
  }
  
}
