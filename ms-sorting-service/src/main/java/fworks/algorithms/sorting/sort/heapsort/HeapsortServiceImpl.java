package fworks.algorithms.sorting.sort.heapsort;

import fworks.algorithms.counter.Counter;
import org.springframework.stereotype.Service;

/**
 * Heapsort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class HeapsortServiceImpl implements HeapsortService {

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
    // return sorted array
    return array;
  }

}
