package fworks.algorithms.searching.search.binarysearch;

import fworks.algorithms.searching.search.AlgorithmSearchService;

/**
 * Binary Search Service.<br>
 * Implements binary search using the recursive approach.
 * 
 * @author flaviolcastro
 *
 */
public interface BinarySearchRecursiveService extends AlgorithmSearchService {

  public static final String BINARY_SEARCH_RECURSIVE = "BinarySearchRecursive";

  @Override
  default String getAlgorithmName() {
    return BINARY_SEARCH_RECURSIVE;
  }
}
