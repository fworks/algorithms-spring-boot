package fworks.algorithms.basics;

import java.util.Comparator;


public interface ArrayService {

  /**
   * Get the max value from an array.
   * 
   * @param array to search
   * @param comparator of the type
   * @return max value
   */
  <T> T getMax(T[] array, Comparator<T> comparator);

  /**
   * Get the max value from an array.
   * 
   * @param array to search
   * @return max value
   */
  double getMax(double[] array);
  
  /**
   * Get the min value from an array.
   * 
   * @param array to search
   * @return min value
   */
  double getMin(double[] array);

  /**
   * Get the sum value from an array.
   * 
   * @param array to search
   * @return sum value
   */
  double getSum(double[] array);

  /**
   * Get the avg value from an array.
   * 
   * @param array to search
   * @return avg value
   */
  double getAvg(double[] array);

  /**
   * Reverse an array.
   * 
   * @param array to be reversed
   * @return reversed array
   */
  double[] reverse(double[] array);

  /**
   * Copy an array.
   * 
   * @param array to be copied
   * @return copied array
   */
  double[] copy(double[] array);

}
