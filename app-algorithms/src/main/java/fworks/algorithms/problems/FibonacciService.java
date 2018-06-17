package fworks.algorithms.problems;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;

/**
 * Fibonacci Service.<br/>
 * <br/>
 * In mathematics, the Fibonacci numbers are the numbers in the following integer sequence, called
 * the Fibonacci sequence, and characterized by the fact that every number after the first two is
 * the sum of the two preceding ones: <br/>
 * <br/>
 * 0,1,1,2,3,5,8,13,21,34,55,89,144,...<br/>
 * <br/>
 * The sequence Fn of Fibonacci numbers is defined by the recurrence relation:<br/>
 * <br/>
 * F{n}=F{n-1}+F{n-2} with seed F{0}=0, F{1}=1.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public class FibonacciService {

  /**
   * Calculate the fibonacci function value.
   * 
   * @param number function number
   * @return value returned
   */
  public long fibonacci(int number) {
    log.debug("fibonacci{{}}=", number);
    if (number == 0 || number == 1) {
      return number;
    }
    return fibonacci(number - 1) + fibonacci(number - 2);
  }

  /**
   * Calculate fibonacci sequence over a number of interactions.
   * 
   * @param numberOfInteractions interactions
   * @return queue with the values
   */
  public long[] calculateFibonacciSequence(int numberOfInteractions) {
    Queue<Long> queue = new QueueLinkedListImpl<>();
    queue.enqueue(0L);
    queue.enqueue(1L);
    for (int i = 2; i < numberOfInteractions; i++) {
      // adds to the result
      queue.enqueue(fibonacci(i));
    }
    // convert to array
    long[] array = new long[queue.size()];
    Iterator<Long> iterator = queue.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      array[i++] = iterator.next();
    }
    return array;
  }

  /**
   * Calculate the fibonacci function value.
   * 
   * @param number function number
   * @param fibonacciCache cache array
   * @return value returned
   */
  private long fibonacciOptimized(int number, long[] fibonacciCache) {
    long cachedValue = fibonacciCache[number];
    if (cachedValue != 0) {
      log.debug("fibonacciOptimized {{}}={}(cached)", number, cachedValue);
      return cachedValue;
    }
    if (number == 0 || number == 1) {
      fibonacciCache[number] = (long) number;
      return (long) number;
    }
    long result = fibonacciOptimized(number - 1, fibonacciCache)
        + fibonacciOptimized(number - 2, fibonacciCache);
    fibonacciCache[number] = result;
    log.debug("fibonacciOptimized {{}}={}", number, result);
    return result;
  }

  /**
   * Calculate fibonacci sequence over a number of interactions.
   * 
   * @param numberOfInteractions interactions
   * @return queue with the values
   */
  public long[] calculateFibonacciSequenceOptimized(int numberOfInteractions) {
    long[] fibonacciCache = new long[numberOfInteractions];
    Queue<Long> queue = new QueueLinkedListImpl<>();
    for (int i = 0; i < numberOfInteractions; i++) {
      // adds to the result
      queue.enqueue(fibonacciOptimized(i, fibonacciCache));
    }
    // convert to array
    long[] array = new long[queue.size()];
    Iterator<Long> iterator = queue.iterator();
    int i = queue.size() - 1;
    while (iterator.hasNext()) {
      array[i--] = iterator.next();
    }
    return array;
  }

  /**
   * Calculate fibonacci sequence over a number of interactions.
   * 
   * @param numberOfInteractions interactions
   * @return queue with the values
   */
  public long[] calculateFibonacciSequenceNotRecursive(int numberOfInteractions) {
    Queue<Long> queue = new QueueLinkedListImpl<>();

    long f = 0;
    long g = 1;
    for (int i = 0; i <= numberOfInteractions; i++) {
      // adds to the result
      queue.enqueue(f);
      // update f
      f = f + g;
      // update g
      g = f - g;
    }
    // convert to array
    long[] array = new long[queue.size()];
    Iterator<Long> iterator = queue.iterator();
    int i = queue.size() - 1;
    while (iterator.hasNext()) {
      array[i--] = iterator.next();
    }
    return array;
  }
}
