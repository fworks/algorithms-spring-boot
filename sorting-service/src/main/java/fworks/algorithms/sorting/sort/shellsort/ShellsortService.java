package fworks.algorithms.sorting.sort.shellsort;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Shellsort service.
 * 
 * @author flaviolcastro
 *
 */
public interface ShellsortService extends AlgorithmSortService {

  public static final String SHELLSORT = "Shellsort";

  @Override
  default String getAlgorithmName() {
    return SHELLSORT;
  }
}
