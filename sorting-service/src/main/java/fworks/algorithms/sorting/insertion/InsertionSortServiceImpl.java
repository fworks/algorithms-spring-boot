package fworks.algorithms.sorting.insertion;

import fworks.algorithms.sorting.Counter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Insertion sort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class InsertionSortServiceImpl implements InsertionSortService {

  @Override
  public long[] sort(long[] array, final Counter counter) {
    return executeSorting(array, counter);
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Comparable[] sort(Comparable[] array, final Counter counter) {
    return executeSorting(array, counter);
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private long[] executeSorting(long[] array, final Counter counter) {
    // for all items
    for (int i = 1; i < array.length; i++) {

      // starts in 1, picking the second element,
      // as it will compare against all the left values of i

      // get current item
      var current = array[i];

      // compare the current against all left values
      for (int j = i; j > 0; j--) {

        // left item
        var leftItem = array[j - 1];

        // if current less than left item
        if (less(current, leftItem)) {

          log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
              array.length > 20 ? "" : array, current, leftItem, "Exchanging");

          // exchange them
          exchange(array, j - 1, j);
          counter.increaseCounter();

        } else {

          log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
              array.length > 20 ? "" : array, current, leftItem, "Ignoring");

          // if not, don't need to compare against the other left items
          // as them are already sorted
          break;
        }

      }
    }

    // return sorted array
    return array;
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private Comparable<?>[] executeSorting(Comparable<?>[] array, final Counter counter) {
    // for all items
    for (int i = 1; i < array.length; i++) {

      // starts in 1, picking the second element,
      // as it will compare against all the left values of i

      // get current item
      var current = array[i];

      // compare the current against all left values
      for (int j = i; j > 0; j--) {

        // left item
        var leftItem = array[j - 1];

        // if current less than left item
        if (less(current, leftItem)) {

          log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
              array.length > 20 ? "" : array, current, leftItem, "Exchanging");

          // exchange them
          exchange(array, j - 1, j);
          counter.increaseCounter();

        } else {

          log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
              array.length > 20 ? "" : array, current, leftItem, "Ignoring");

          // if not, don't need to compare against the other left items
          // as them are already sorted
          break;
        }

      }
    }

    // return sorted array
    return array;
  }
}
