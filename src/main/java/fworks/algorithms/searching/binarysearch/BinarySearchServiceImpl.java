package fworks.algorithms.searching.binarysearch;

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

  @Override
  public int search(long key, long[] array) {
    int minPos = 0;
    int maxPos = array.length - 1;
    while (minPos <= maxPos) {
      log.debug("Loop Search: key: {} minPos: {} maxPos: {}", key, minPos, maxPos);
      int middlePos = minPos + (maxPos - minPos) / 2;
      long middleValue = array[middlePos];
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

  @Override
  public SearchResponse search(SearchRequest request) {
    long key = request.getKey();
    long[] array = request.getArray();
    Instant start = Instant.now();
    int result = this.search(key, array);
    SearchResponse searchResult = SearchResponse.builder() //
        .algorithm("BinarySearchLoop") //
        .arraySize(array.length) //
        .index(result) //
        .numberOfKeysAnalized(0) //
        .duration(Duration.between(start, Instant.now())) //
        .build();
    log.debug("Search for key: {} on arraySize: {} = {}", key, array.length, result);
    return searchResult;
  }
}
