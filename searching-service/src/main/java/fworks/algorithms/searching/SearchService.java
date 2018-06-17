package fworks.algorithms.searching;

/**
 * Search Service.
 * 
 * @author flaviolcastro
 *
 */
public interface SearchService {

  /**
   * Execute a search on an array.
   * 
   * @param key to be searched
   * @param array to find
   * @return index of the key if found,<br/>
   *         -1 if not found.
   */
  int search(long key, long[] array);

  /**
   * Execute a search based on the request.
   * 
   * @param request params to search
   * @return search response
   */
  SearchResponse search(SearchRequest request);
}
