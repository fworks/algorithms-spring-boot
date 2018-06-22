package fworks.algorithms.searching.bruteforce;

import fworks.algorithms.searching.Counter;
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
  public int search(long key, long[] array, Counter counter) {
    return this.executeSearch(key, array, counter);
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
