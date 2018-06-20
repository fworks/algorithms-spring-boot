package fworks.algorithms.problems;

import java.time.Duration;
import java.time.Instant;

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
   * @param counter of analysed key
   * @return index of the key if found,<br/>
   *         -1 if not found.
   */
  int search(long key, long[] array, Counter counter);

  /**
   * Execute a search based on the request.
   * 
   * @param request params to search
   * @return search response
   */
  default SearchResponse search(SearchRequest request) {
    long key = request.getKey();
    long[] array = request.getArray();
    Counter counter = new Counter();
    // execute the search marking the time
    Instant start = Instant.now();
    int result = this.search(key, array, counter);
    Duration duration = Duration.between(start, Instant.now());
    // return the result
    SearchResponse searchResponse = SearchResponse.builder() //
        .algorithm(getAlgorithmName()) //
        .arraySize(array.length) //
        .index(result) //
        .numberOfKeysAnalized(counter.getCounter()) //
        .duration(duration) //
        .build();
    return searchResponse;
  }
  
  /**
   * Return the algorithm name/implementation.
   * @return name
   */
  String getAlgorithmName();
  
}
