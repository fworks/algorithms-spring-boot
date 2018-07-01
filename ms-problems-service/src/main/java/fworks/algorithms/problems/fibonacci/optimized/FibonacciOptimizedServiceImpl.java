package fworks.algorithms.problems.fibonacci.optimized;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Fibonacci service implementation using an optimized algorithm.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class FibonacciOptimizedServiceImpl implements FibonacciOptimizedService {

  @Override
  public long[] calculateFibonacciSequence(int numberOfIteractions) {
    log.debug("calcuating fibonacci for {} interation(s)", numberOfIteractions);
    long[] fibonacciCache = new long[numberOfIteractions];
    Queue<Long> queue = new QueueLinkedListImpl<>();
    for (int i = 0; i < numberOfIteractions; i++) {
      // adds to the result
      queue.enqueue(fibonacciOptimized(i, fibonacciCache));
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

}
