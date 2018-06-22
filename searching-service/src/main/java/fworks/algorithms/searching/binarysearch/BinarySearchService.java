package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.SearchService;

/**
 * Binary Search Service.<br>
 * Implements binary search using the internal loop approach.
 * 
 * @author flaviolcastro
 *
 */
public interface BinarySearchService extends SearchService {
  
  public static final String BINARY_SEARCH_LOOP = "BinarySearchLoop";

  @Override
  default String getAlgorithmName() {
    return BINARY_SEARCH_LOOP;
  }
}
