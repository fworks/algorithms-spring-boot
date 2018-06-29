package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.api.model.Counter;
import org.springframework.stereotype.Service;

/**
 * Quick3way sorting service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class Quick3wayServiceImpl implements Quick3wayService {

  @Override
  public long[] sort(long[] array, final Counter counter) {
    return executeSorting(array, 0, array.length - 1, counter);
  }

  @Override
  @SuppressWarnings("rawtypes")
  public Comparable[] sort(Comparable[] array, final Counter counter) {
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
      final Counter counter) {

    if (rightPosition <= leftPosition) {
      //
      return array;
    }

    var lt = leftPosition;
    var i = leftPosition + 1;
    var gt = rightPosition;

    // get first value
    var value = array[leftPosition];

    while (i <= gt) {
      
      var test = array[i];

      if (less(test, value)) {
        
        exchange(array, lt++, i++);
        counter.increaseCounter();

      } else if (less(value, test)) {
        
        // don't exchange if it is the same position
        if(gt != i) {
          exchange(array, i, gt--);
          counter.increaseCounter();
        } else {
          gt--;
        }

      } else {
        i++;

      }
    }

    this.executeSorting(array, leftPosition, lt - 1, counter);
    this.executeSorting(array, gt + 1, rightPosition, counter);

    return array;
  }

  /**
   * Execute the sorting on the array.
   * 
   * @param array to be sorted
   * @param counter of positions exchanges
   * @return sorted array
   */
  private Comparable<?>[] executeSorting(Comparable<?>[] array, int leftPosition, int rightPosition,
      final Counter counter) {
    if (rightPosition <= leftPosition) {
      //
      return array;
    }

    var lt = leftPosition;
    var i = leftPosition + 1;
    var gt = rightPosition;

    // get first value
    var value = array[leftPosition];

    while (i <= gt) {
      
      var test = array[i];

      if (less(test, value)) {
        
        // don't exchange if it is the same position
        if(lt != i) {
          exchange(array, lt++, i++);
          counter.increaseCounter();
        } else {
          lt++;
          i++;
        }

      } else if (less(value, test)) {
        
        // don't exchange if it is the same position
        if(gt != i) {
          exchange(array, i, gt--);
          counter.increaseCounter();
        } else {
          gt--;
        }

      } else {
        i++;

      }
    }

    this.executeSorting(array, leftPosition, lt - 1, counter);
    this.executeSorting(array, gt + 1, rightPosition, counter);

    return array;
  }

}
