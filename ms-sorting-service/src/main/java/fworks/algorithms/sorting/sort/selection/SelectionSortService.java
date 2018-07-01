package fworks.algorithms.sorting.sort.selection;

import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Selection sort service.
 * 
 * @author flaviolcastro
 *
 */
public interface SelectionSortService extends AlgorithmSortService {

  public static final String SELECTION_SORT = "SelectionSort";

  @Override
  default String getAlgorithmName() {
    return SELECTION_SORT;
  }
}
