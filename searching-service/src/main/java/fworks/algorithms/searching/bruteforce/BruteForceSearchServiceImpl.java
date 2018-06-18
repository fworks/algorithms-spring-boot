package fworks.algorithms.searching.bruteforce;

import fworks.algorithms.searching.Counter;
import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Brute Force Service.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class BruteForceSearchServiceImpl implements BruteForceSearchService {

  private static final String BRUTE_FORCE = "BruteForce";

  @Override
  public int search(long key, long[] array) {
    log.debug("Searching {} in {}", key, array);
    return this.executeSearch(key, array, new Counter());
  }

  @Override
  public SearchResponse search(SearchRequest request) {
    Counter counter = new Counter();
    // execute the search marking the time
    Instant start = Instant.now();
    int result = this.executeSearch(request.getKey(), request.getArray(), counter);
    Duration duration = Duration.between(start, Instant.now());
    // return the result
    SearchResponse searchResponse = SearchResponse.builder() //
        .algorithm(BRUTE_FORCE) //
        .arraySize(request.getArray().length) //
        .index(result) //
        .numberOfKeysAnalized(result != -1 ? result + 1 : request.getArray().length) //
        .duration(duration) //
        .build();
    return searchResponse;
  }
  
  /**
   * Execute the brute force search.
   * 
   * @param key to be found
   * @param array to be searched
   * @param counter of key analysed
   * @return index position of the key, or -1 if not found
   */
  public int executeSearch(long key, long[] array, Counter counter) {
    log.debug("Searching {} in {}", key, array);
    for (int i = 0; i < array.length; i++) {
      counter.increaseCounter();
      if (array[i] == key) {
        return i;
      }
    }
    return -1;
  }
}
