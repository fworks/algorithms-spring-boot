package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.Counter;
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
  public String getAlgorithmName() {
    return BINARY_SEARCH_LOOP;
  }
  
  @Override
  public int search(long key, long[] array, Counter counter) {
    // execute the search
    return this.executeSearch(key, array, counter);
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
