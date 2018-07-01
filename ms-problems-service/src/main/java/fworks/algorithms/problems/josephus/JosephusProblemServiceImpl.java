package fworks.algorithms.problems.josephus;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Josephus problem service implementation.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class JosephusProblemServiceImpl implements JosephusProblemService {

  @Override
  public int solve(Integer m, Integer n) {
    Queue<Integer> queue = new QueueArrayImpl<>();

    // add the n items
    for (int i = 0; i < n; i++) {
      queue.enqueue(i);
    }

    int lastPosition = 0;

    // get with the position m
    while (!queue.isEmpty()) {
      // dequeue
      for (int i = 0; i < m - 1; i++) {
        Integer item = queue.dequeue();
        // add again because it is not at m position
        queue.enqueue(item);
      }
      lastPosition = queue.dequeue();
      log.info(lastPosition);
    }

    return lastPosition;
  }
}
