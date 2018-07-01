package fworks.algorithms.sorting.sort.shellsort;

import fworks.algorithms.counter.Counter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Shellsort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class ShellsortServiceImpl implements ShellsortService {

  @Override
  public long[] sort(long[] array, Counter counter) {
    return executeSorting(array, counter);
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Comparable[] sort(Comparable[] array, Counter counter) {
    return executeSorting(array, counter);
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private long[] executeSorting(long[] array, Counter counter) {

    // calculate the h
    var h = 1;
    // calculate the h until it get bigger than one third of the array
    while (h < array.length / 3) {
      h = 3 * h + 1;
    }

    // execute the sort using the h
    while (h >= 1) {

      // from h
      for (int i = h; i < array.length; i++) {

        for (int j = i; j >= h; j = j - h) {

          // get current item
          var current = array[j];
          
          // get previous hth item
          var previousHth = array[j - h];
          
          // if current is less than previoushth 
          if (less(current, previousHth)) {
            
            log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
                array.length > 20 ? "" : array, current, previousHth, "Exchanging");

            // exchange them
            exchange(array, j, j - h);
            counter.increaseCounter();

          } else {
            
            log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
                array.length > 20 ? "" : array, current, previousHth, "Ignoring");

            // if not, don't need to compare against the other left items
            // as them are already sorted
            break;
          }
        }
      }
      
      // update h
      h = h / 3;
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
  private Comparable<?>[] executeSorting(Comparable<?>[] array, Counter counter) {

    // calculate the h
    var h = 1;
    // calculate the h until it get bigger than one third of the array
    while (h < array.length / 3) {
      h = 3 * h + 1;
    }

    // execute the sort using the h
    while (h >= 1) {

      // from h
      for (int i = h; i < array.length; i++) {

        for (int j = i; j >= h; j = j - h) {

          // get current item
          var current = array[j];
          
          // get previous hth item
          var previousHth = array[j - h];
          
          // if current is less than previoushth 
          if (less(current, previousHth)) {
            
            log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
                array.length > 20 ? "" : array, current, previousHth, "Exchanging");

            // exchange them
            exchange(array, j, j - h);
            counter.increaseCounter();

          } else {
            
            log.debug("Step: {}-{} Array: {} Current: {} Left: {} --> {}", i, j,
                array.length > 20 ? "" : array, current, previousHth, "Ignoring");

            // if not, don't need to compare against the other left items
            // as them are already sorted
            break;
          }
        }
      }
      
      // update h
      h = h / 3;
    }

    // return sorted array
    return array;
  }

}
