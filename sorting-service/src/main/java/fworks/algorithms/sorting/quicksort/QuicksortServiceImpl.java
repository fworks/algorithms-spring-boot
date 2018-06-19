package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.Counter;
import org.springframework.stereotype.Service;

/**
 * Quicksort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class QuicksortServiceImpl implements QuicksortService {

  private static final String QUICKSORT = "Quicksort";

  @Override
  public String getAlgorithmName() {
    return QUICKSORT;
  }

  @Override
  public long[] sort(long[] array, Counter counter) {
    return executeSorting(array, 0, array.length - 1, counter);
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Comparable[] sort(Comparable[] array, Counter counter) {
    return executeSorting(array, 0, array.length - 1, counter);
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private long[] executeSorting(long[] array, int leftPosition, int rightPosition,
      Counter counter) {

    if (rightPosition <= leftPosition) {
      //
      return array;
    }

    int partition = this.partition(array, leftPosition, rightPosition, counter);

    array = this.executeSorting(array, leftPosition, partition - 1, counter);
    array = this.executeSorting(array, partition + 1, rightPosition, counter);

    // return sorted array
    return array;
  }

  private int partition(long[] array, int leftPosition, int rightPosition, Counter counter) {

    // get first value
    var value = array[leftPosition];

    var i = leftPosition;
    var j = rightPosition + 1;

    while (i < j) {
      // while the leftPosition less the rightPosition

      var test = 0L;

      do {
        // go from left position until find a bigger value than value

        test = array[++i];

      } while (less(test, value) && i < rightPosition);

      do {
        // go from right position until find a smaller value than value

        test = array[--j];

      } while (less(value, test) && j > leftPosition);

      if (i < j) {
        // exchange the positions
        exchange(array, i, j);
        counter.increaseCounter();
      }

    }

    // exchange the left position with the right position
    exchange(array, leftPosition, j);
    counter.increaseCounter();

    // return right position
    return j;
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private Comparable<?>[] executeSorting(Comparable<?>[] array, int leftPosition, int rightPosition,
      Counter counter) {

    if (rightPosition <= leftPosition) {
      //
      return array;
    }

    int partition = this.partition(array, leftPosition, rightPosition, counter);

    array = this.executeSorting(array, leftPosition, partition - 1, counter);
    array = this.executeSorting(array, partition + 1, rightPosition, counter);

    // return sorted array
    return array;
  }

  @SuppressWarnings("rawtypes")
  private int partition(Comparable[] array, int leftPosition, int rightPosition, Counter counter) {

    // get first value
    var value = array[leftPosition];

    var i = leftPosition;
    var j = rightPosition + 1;

    while (i < j) {
      // while the leftPosition less the rightPosition

      Comparable<?> test = null;

      do {
        // go from left position until find a bigger value than value

        test = array[++i];

      } while (less(test, value) && i < rightPosition);

      do {
        // go from right position until find a smaller value than value

        test = array[--j];

      } while (less(value, test) && j > leftPosition);

      if (i < j) {
        // exchange the positions
        exchange(array, i, j);
        counter.increaseCounter();
      }

    }

    // exchange the left position with the right position
    exchange(array, leftPosition, j);
    counter.increaseCounter();

    // return right position
    return j;
  }

}
