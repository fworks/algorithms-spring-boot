package fworks.algorithms.problems.fibonacci.simple;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Simple fibonacci implementation.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class FibonacciSimpleServiceImpl implements FibonacciSimpleService {

  @Override
  public long[] calculateFibonacciSequence(int numberOfIteractions) {
    log.debug("calcuating fibonacci for {} interation(s)", numberOfIteractions);
    Queue<Long> queue = new QueueLinkedListImpl<>();
    queue.enqueue(0L);
    queue.enqueue(1L);
    for (int i = 2; i < numberOfIteractions; i++) {
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

}
