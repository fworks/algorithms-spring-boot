package fworks.algorithms.sorting.selection;

import fworks.algorithms.sorting.Counter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Selection sort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class SelectionSortServiceImpl implements SelectionSortService {

  private static final String SELECTION_SORT = "SelectionSort";

  @Override
  public String getAlgorithmName() {
    return SELECTION_SORT;
  }
  
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
    
    
    // for all items
    for (int i = 0; i < array.length; i++) {

      // find the smallest item

      // keep track of the minimum position
      int minPos = i;

      // compare against the others (right values)
      for (int j = i + 1; j < array.length; j++) {

        // get current item
        long current = array[minPos];

        // next value
        long nextItem = array[j];


        // if next is less than current
        if (less(nextItem, current)) {

          // update the min position with the next position
          minPos = j;
        }

        log.debug("Step: {}-{} Array: {} Current: {} Next: {} Min: {}", i, j, array.length > 20 ? "" : array, current,
            nextItem, minPos);
      }

      log.debug("Exchanging positions {}-{} Array: {}", i, minPos, array.length > 20 ? "" : array);

      // exchange the current position with the min position
      exchange(array, i, minPos);
      counter.increaseCounter();

      log.debug("Positions Exchanged - Array: {}", array.length > 20 ? "" : array);

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
  @SuppressWarnings("rawtypes")
  private Comparable[] executeSorting(Comparable[] array, Counter counter) {
    // for all items
    for (int i = 0; i < array.length; i++) {
      
      // find the smallest item
      
      // keep track of the minimum position
      int minPos = i;
      
      // compare against the others (right values)
      for (int j = i + 1; j < array.length; j++) {
        
        // get current item
        Comparable current = array[minPos];
        
        // next value
        Comparable nextItem = array[j];
        
        
        // if next is less than current
        if (less(nextItem, current)) {
          
          // update the min position with the next position
          minPos = j;
        }
        
        log.debug("Step: {}-{} Array: {} Current: {} Next: {} Min: {}", i, j, array.length > 20 ? "" : array, current,
            nextItem, minPos);
      }
      
      log.debug("Exchanging positions {}-{} Array: {}", i, minPos, array.length > 20 ? "" : array);
      
      // exchange the current position with the min position
      exchange(array, i, minPos);
      counter.increaseCounter();
      
      log.debug("Positions Exchanged - Array: {}", array.length > 20 ? "" : array);
      
    }
    
    // return sorted array
    return array;
  }

}
