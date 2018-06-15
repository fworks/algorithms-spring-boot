package fworks.algorithms.searching.bruteforce;

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

  @Override
  public int search(long key, long[] array) {
    log.info("Searching {} in {}", key, array);
    for (int i = 0; i < array.length; i++) {
      if (array[i] == key) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public SearchResponse search(SearchRequest request) {
    Instant start = Instant.now();
    int result = search(request.getKey(), request.getArray());
    SearchResponse searchResult = SearchResponse.builder()
        .algorithm("BruteForce")
        .arraySize(request.getArray().length)
        .index(result)
        .numberOfKeysAnalized(result != -1 ? result : request.getArray().length)
        .duration(Duration.between(start, Instant.now()))
        .build();
    return searchResult;
  }
}
