package fworks.algorithms.searching.binary;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Implements the binary search using a recursive method.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class BinarySearchImpl implements BinarySearch {

  @Override
  public int searchRecursive(long key, long[] sortedArray) {
    int result = this.searchRecursiveAuxiliary(key, sortedArray, 0);
    log.debug("Search for {} on {} = {}", key, sortedArray, result);
    return result;
  }
  
  @Override
  public SearchResponse searchRecursive(SearchRequest request) {
    Instant start = Instant.now();
    int result = this.searchRecursiveAuxiliary(request.getKey(), request.getArray(), 0);
    log.debug("Search for {} on {} = {}", request.getKey(), request.getArray(), result);
    return new SearchResponse(result, 0, Duration.between(start, Instant.now()).toMillis());
  }

  /**
   * Execute the search.
   * 
   * @param key to be found
   * @param sortedArray array to search into
   * @param indexCount accumulate position of the index
   * @return position of the key
   */
  private int searchRecursiveAuxiliary(long key, long[] sortedArray, int indexCount) {
    // validate first and last positon
    log.debug("Recursive Search: key: {} indexCount: {} array: {}", key, indexCount, sortedArray);

    long min = sortedArray[0];
    long max = sortedArray[sortedArray.length - 1];
    if (key < min || key > max) {
      return -1;
    }
    if (key == min) {
      return indexCount + 0;
    }
    if (key == max) {
      return indexCount + sortedArray.length - 1;
    }

    // do binary search

    int position = sortedArray.length / 2;
    long value = sortedArray[position];

    if (key == value) {
      // found it
      return indexCount + position;
    }

    if (sortedArray.length == 1) {
      // not found
      return -1;
    }

    // if greater than value
    if (key > value) {
      // research using the right size array
      long[] newArray = new long[sortedArray.length - position];
      System.arraycopy(sortedArray, position, newArray, 0, sortedArray.length - position);
      return this.searchRecursiveAuxiliary(key, newArray, indexCount + position);

    } else {
      // research using the left size array
      long[] newArray = new long[sortedArray.length - position];
      System.arraycopy(sortedArray, 0, newArray, 0, sortedArray.length - position);
      return this.searchRecursiveAuxiliary(key, newArray, indexCount);
    }
  }

  @Override
  public int searchLoop(long key, long[] array) {
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
  public SearchResponse searchLoop(SearchRequest request) {
    Instant start = Instant.now();
    int result = this.searchLoop(request.getKey(), request.getArray());
    log.debug("Search for {} on {} = {}", request.getKey(), request.getArray(), result);
    return new SearchResponse(result, 0, Duration.between(start, Instant.now()).toMillis());
  }
}
