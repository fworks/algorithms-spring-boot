package fworks.algorithms.sorting.selection;

import fworks.algorithms.sorting.SortingService;

/**
 * Selection sort service.
 * 
 * @author flaviolcastro
 *
 */
public interface SelectionSortService extends SortingService {

  public static final String SELECTION_SORT = "SelectionSort";

  @Override
  default String getAlgorithmName() {
    return SELECTION_SORT;
  }
}
