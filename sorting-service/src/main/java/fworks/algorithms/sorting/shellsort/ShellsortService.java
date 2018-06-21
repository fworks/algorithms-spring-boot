package fworks.algorithms.sorting.shellsort;

import fworks.algorithms.sorting.SortingService;

/**
 * Shellsort service.
 * 
 * @author flaviolcastro
 *
 */
public interface ShellsortService extends SortingService {

  public static final String SHELLSORT = "Shellsort";

  @Override
  default String getAlgorithmName() {
    return SHELLSORT;
  }
}
