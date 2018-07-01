package fworks.algorithms.problems.fibonacci.nonrecursive;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Fibonacci non recursive implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class FibonacciNonRecursiveServiceImpl implements FibonacciNonRecursiveService {

  @Override
  public long[] calculateFibonacciSequence(int numberOfIteractions) {
    log.debug("calcuating fibonacci for {} iteration(s)", numberOfIteractions);
    Queue<Long> queue = new QueueLinkedListImpl<>();

    long f = 0;
    long g = 1;
    for (int i = 0; i < numberOfIteractions; i++) {
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
    int i = 0;
    while (iterator.hasNext()) {
      array[i++] = iterator.next();
    }
    return array;
  }

}
