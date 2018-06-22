package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.Counter;
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
  public int search(long key, long[] array, Counter counter) {
    return this.executeSearch(key, array, 0, counter);
  }

  /**
   * Execute the search.
   * 
   * @param key to be found
   * @param array array to search into
   * @param indexCount accumulate position of the index
   * @param counter of analysed key
   * @return index position of the key, or -1 if not found
   */
  private int executeSearch(long key, long[] array, int indexCount, Counter counter) {
    log.debug("Recursive: key: {} indexCount: {} arraySize: {}", key, indexCount, array.length);
    
    // validate first and last positon
    long min = array[0];
    long max = array[array.length - 1];
    if (key < min || key > max) {
      return -1;
    }
    counter.increaseCounter();
    if (key == min) {
      return indexCount + 0;
    }
    counter.increaseCounter();
    if (key == max) {
      return indexCount + array.length - 1;
    }

    // do binary search

    int position = array.length / 2;
    long value = array[position];

    counter.increaseCounter();
    if (key == value) {
      // found it
      return indexCount + position;
    }

    // if greater than value
    if (key > value) {
      // research using the right size array
      long[] newArray = new long[array.length - position];
      System.arraycopy(array, position, newArray, 0, array.length - position);
      return this.executeSearch(key, newArray, indexCount + position, counter);

    } else {
      // research using the left size array
      long[] newArray = new long[array.length - position];
      System.arraycopy(array, 0, newArray, 0, array.length - position);
      return this.executeSearch(key, newArray, indexCount, counter);
    }
  }
}
