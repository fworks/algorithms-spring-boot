package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Implements binary search using the recursive approach.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class BinarySearchRecursiveServiceImpl implements BinarySearchRecursiveService {

  @Override
  public int search(long key, long[] sortedArray) {
    int result = this.searchRecursiveAuxiliary(key, sortedArray, 0);
    // log.debug("Search for {} on {} = {}", key, sortedArray, result);
    return result;
  }

  @Override
  public SearchResponse search(SearchRequest request) {
    Instant start = Instant.now();
    int result = this.searchRecursiveAuxiliary(request.getKey(), request.getArray(), 0);
    // log.debug("Search for {} on {} = {}", request.getKey(), request.getArray(), result);
    SearchResponse searchResult = SearchResponse.builder() //
        .algorithm("BinarySearchRecursive") //
        .arraySize(request.getArray().length) //
        .index(result).numberOfKeysAnalized(0) //
        .duration(Duration.between(start, Instant.now())) //
        .build();
    return searchResult;
  }

  /**
   * Execute the search.
   * 
   * @param key to be found
   * @param array array to search into
   * @param indexCount accumulate position of the index
   * @return position of the key
   */
  private int searchRecursiveAuxiliary(long key, long[] array, int indexCount) {
    // validate first and last positon
    log.debug("Recursive: key: {} indexCount: {} arraySize: {}", key, indexCount, array.length);
    long min = array[0];
    long max = array[array.length - 1];
    if (key < min || key > max) {
      return -1;
    }
    if (key == min) {
      return indexCount + 0;
    }
    if (key == max) {
      return indexCount + array.length - 1;
    }

    // do binary search

    int position = array.length / 2;
    long value = array[position];

    if (key == value) {
      // found it
      return indexCount + position;
    }

    if (array.length == 1) {
      // not found
      return -1;
    }

    // if greater than value
    if (key > value) {
      // research using the right size array
      long[] newArray = new long[array.length - position];
      System.arraycopy(array, position, newArray, 0, array.length - position);
      return this.searchRecursiveAuxiliary(key, newArray, indexCount + position);

    } else {
      // research using the left size array
      long[] newArray = new long[array.length - position];
      System.arraycopy(array, 0, newArray, 0, array.length - position);
      return this.searchRecursiveAuxiliary(key, newArray, indexCount);
    }
  }
}
