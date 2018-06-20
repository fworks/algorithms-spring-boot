package fworks.algorithms.sorting.mergesort;

import fworks.algorithms.sorting.Counter;
import org.springframework.stereotype.Service;

/**
 * Mergesort service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class MergesortServiceImpl implements MergesortService {

  private static final String MERGESORT = "Mergesort";

  @Override
  public String getAlgorithmName() {
    return MERGESORT;
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
    
    if(array.length == 2) {
      
      var leftValue = array[0];
      var rightValue = array[1];
      
      if(less(rightValue, leftValue)) {
        
        exchange(array, 0, 1);
        
      }
      
    } else if(array.length > 2) {
      
      int half = array.length / 2;
      int rest = array.length % 2;
      
      long[] leftArray = new long[half];
      System.arraycopy(array, 0, leftArray, 0, half);
      
      leftArray = executeSorting(leftArray, counter);
      
      long[] rightArray = new long[half+rest];
      System.arraycopy(array, half, rightArray, 0, half+rest);
      
      rightArray = executeSorting(rightArray, counter);
      
      long right = rightArray[0];
      long left = leftArray[leftArray.length-1];
      
      if(less(left, right)) {

        // array sorted!
        System.arraycopy(leftArray, 0, array, 0, leftArray.length);
        System.arraycopy(rightArray, 0, array, half, rightArray.length);
        
      } else {
        
        int leftPos = 0;
        int rightPos = 0;
        for (int i = 0; i < array.length; i++) {
          
          left = leftArray.length > leftPos ? leftArray[leftPos] : Long.MAX_VALUE;
          right = rightArray.length > rightPos ? rightArray[rightPos] : Long.MAX_VALUE;
          
          if(less(left, right)) {
            array[i] = left;
            leftPos++;
          } else {
            array[i] = right;
            rightPos++;
          }
          counter.increaseCounter();
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
  private Comparable<?>[] executeSorting(Comparable<?>[] array, Counter counter) {

    if(array.length == 2) {
      
      var leftValue = array[0];
      var rightValue = array[1];
      
      if(less(rightValue, leftValue)) {
        
        exchange(array, 0, 1);
        
      }
      
    } else if(array.length > 2) {
      
      int half = array.length / 2;
      int rest = array.length % 2;
      
      Comparable<?>[] leftArray = new Comparable<?>[half];
      System.arraycopy(array, 0, leftArray, 0, half);
      
      leftArray = executeSorting(leftArray, counter);
      
      Comparable<?>[] rightArray = new Comparable<?>[half+rest];
      System.arraycopy(array, half, rightArray, 0, half+rest);
      
      rightArray = executeSorting(rightArray, counter);
      
      Comparable<?> right = rightArray[0];
      Comparable<?> left = leftArray[leftArray.length-1];
      
      if(less(left, right)) {

        // array sorted!
        System.arraycopy(leftArray, 0, array, 0, leftArray.length);
        System.arraycopy(rightArray, 0, array, half, rightArray.length);
        
      } else {
        
        int leftPos = 0;
        int rightPos = 0;
        for (int i = 0; i < array.length; i++) {
          
          left = leftArray.length > leftPos ? leftArray[leftPos] : null;
          right = rightArray.length > rightPos ? rightArray[rightPos] : null;
          
          if(less(left, right)) {
            array[i] = left;
            leftPos++;
          } else {
            array[i] = right;
            rightPos++;
          }
          counter.increaseCounter();
        }
        
      }
    }
    
    // return sorted array
    return array;
  }

}
