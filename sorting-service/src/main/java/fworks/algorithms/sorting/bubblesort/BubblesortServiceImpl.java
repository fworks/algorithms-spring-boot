package fworks.algorithms.sorting.bubblesort;

import fworks.algorithms.api.model.Counter;
import org.springframework.stereotype.Service;

/**
 * Heapsort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class BubblesortServiceImpl implements BubblesortService {

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

    for (int i = 0; i < array.length - 1; i++) {
      // execute n times

      // go through the array
      for (int j = 0; j < array.length - 1; j++) {

        var first = array[j];
        var second = array[j + 1];

        // compare index to the next
        if (less(second, first) && j != j+1) {

          // if second smaller, exchange it
          exchange(array, j, j + 1);
          counter.increaseCounter();
        }
      }
    }
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
    
    for (int i = 0; i < array.length - 1; i++) {
      // execute n times

      // go through the array
      for (int j = 0; j < array.length - 1; j++) {

        var first = array[j];
        var second = array[j + 1];

        // compare index to the next
        if (less(second, first) && j != j+1) {

          // if second smaller, exchange it
          exchange(array, j, j + 1);
          counter.increaseCounter();
        }
      }
    }
    return array;
  }

}
