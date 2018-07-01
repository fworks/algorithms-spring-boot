package fworks.algorithms.sorting.sort;

import fworks.algorithms.counter.Counter;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;
import fworks.algorithms.sorting.model.sortingrequest.SortingResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Sorting Service.
 * 
 * @author flaviolcastro
 *
 */
public interface AlgorithmSortService {

  /**
   * Execute a sort on an array.
   * 
   * @param array to be sorted
   * @param counter of exchanges
   * @return sorted array.
   */
  long[] sort(long[] array, final Counter counter);

  /**
   * Execute a sort on an array.
   * 
   * @param array to be sorted
   * @return sorted array.
   */
  @SuppressWarnings("rawtypes")
  Comparable[] sort(Comparable[] array, final Counter counter);


  /**
   * Execute a sort based on the request.
   * 
   * @param request params to sort
   * @return sort response
   */
  default SortingResponse sort(final SortingRequest request) {
    Counter counter = new Counter();
    // sort the array marking the time
    var array = Arrays.copyOf(request.getArray(), request.getArray().length);
    Instant start = Instant.now();
    var sorted = this.sort(array, counter);
    Duration duration = Duration.between(start, Instant.now());
    // return the result
    SortingResponse sortingResponse = SortingResponse.builder() //
        .algorithm(getAlgorithmName()) //
        .sortedArray(sorted) //
        .numberOfExchanges(counter.getCounter()) //
        .duration(duration) //
        //.sortingRequest(request) //
        .build();
    return sortingResponse;
  }

  /**
   * Return the algorithm name/implementation.
   * 
   * @return name
   */
  String getAlgorithmName();

  /**
   * Verify if a is less than b.
   * 
   * @param a value
   * @param b value
   * @return true, if a < b<br>
   *         false, otherwise
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  default boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  /**
   * Exchange position on an array.
   * 
   * @param array to have the exchange done
   * @param position1 position 1
   * @param position2 position 2
   */
  default <T> void exchange(T[] array, int position1, int position2) {
    var position1Value = array[position1];
    array[position1] = array[position2];
    array[position2] = position1Value;
  }

  /**
   * Exchange position on an array.
   * 
   * @param array to have the exchange done
   * @param position1 position 1
   * @param position2 position 2
   */
  default void exchange(long[] array, int position1, int position2) {
    var position1Value = array[position1];
    array[position1] = array[position2];
    array[position2] = position1Value;
  }
}
