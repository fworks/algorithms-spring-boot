package fworks.algorithms.searching.binary;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;

/**
 * Binary Search Service.
 * 
 * @author flaviolcastro
 *
 */
public interface BinarySearch {

  /**
   * Execute a binary search using the recursive approach.
   * 
   * @param key to be searched
   * @param array to find
   * @return index of the key if found,<br/>
   *         -1 if not found.
   */
  int searchRecursive(long key, long[] array);

  /**
   * Execute a search based on the request.
   * 
   * @param request params to search
   * @return search response
   */
  SearchResponse searchRecursive(SearchRequest request);
  
  /**
   * Execute a binary search using the internal loop approach.
   * 
   * @param key to be searched
   * @param array to find
   * @return index of the key if found,<br/>
   *         -1 if not found.
   */
  int searchLoop(long key, long[] array);


  /**
   * Execute a search based on the request.
   * 
   * @param request params to search
   * @return search response
   */
  SearchResponse searchLoop(SearchRequest request);
}
