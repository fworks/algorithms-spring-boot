package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.SearchService;

/**
 * Binary Search Service.<br>
 * Implements binary search using the recursive approach.
 * 
 * @author flaviolcastro
 *
 */
public interface BinarySearchRecursiveService extends SearchService {

  public static final String BINARY_SEARCH_RECURSIVE = "BinarySearchRecursive";

  @Override
  default String getAlgorithmName() {
    return BINARY_SEARCH_RECURSIVE;
  }
}
