package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.Counter;
import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Implements binary search using the internal loop approach.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class BinarySearchServiceImpl implements BinarySearchService {

  private static final String BINARY_SEARCH_LOOP = "BinarySearchLoop";

  @Override
  public int search(long key, long[] array) {
    // execute the search
    return this.executeSearch(key, array, new Counter());
  }

  @Override
  public SearchResponse search(SearchRequest request) {
    long key = request.getKey();
    long[] array = request.getArray();
    Counter counter = new Counter();
    // execute the search marking the time
    Instant start = Instant.now();
    int result = this.executeSearch(key, array, counter);
    Duration duration = Duration.between(start, Instant.now());
    // return the result
    SearchResponse searchResponse = SearchResponse.builder() //
        .algorithm(BINARY_SEARCH_LOOP) //
        .arraySize(array.length) //
        .index(result) //
        .numberOfKeysAnalized(counter.getCounter()) //
        .duration(duration) //
        .build();
    log.debug("Search for key: {} on arraySize: {} = {}", key, array.length, result);
    return searchResponse;
  }

  /**
   * Execute the binary search.
   * 
   * @param key to be found
   * @param array to be searched
   * @param counter of key analysed
   * @return index position of the key, or -1 if not found
   */
  public int executeSearch(long key, long[] array, Counter counter) {
    int minPos = 0;
    int maxPos = array.length - 1;
    while (minPos <= maxPos) {
      log.debug("Loop Search: key: {} minPos: {} maxPos: {}", key, minPos, maxPos);
      int middlePos = minPos + (maxPos - minPos) / 2;
      long middleValue = array[middlePos];
      counter.increaseCounter();
      if (key == middleValue) {
        return middlePos;
      }
      if (key < middleValue) {
        // left leg
        maxPos = middlePos - 1;
      } else {
        // right leg
        minPos = middlePos + 1;
      }
    }
    return -1;
  }


}
