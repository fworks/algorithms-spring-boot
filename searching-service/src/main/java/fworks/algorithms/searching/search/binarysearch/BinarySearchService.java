package fworks.algorithms.searching.search.binarysearch;

import fworks.algorithms.searching.search.AlgorithmSearchService;

/**
 * Binary Search Service.<br>
 * Implements binary search using the internal loop approach.
 * 
 * @author flaviolcastro
 *
 */
public interface BinarySearchService extends AlgorithmSearchService {
  
  public static final String BINARY_SEARCH_LOOP = "BinarySearchLoop";

  @Override
  default String getAlgorithmName() {
    return BINARY_SEARCH_LOOP;
  }
}
