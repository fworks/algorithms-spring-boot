package fworks.algorithms.problems.basics;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.stack.Stack;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Copy service.<br/>
 * Execute copy of data structures.
 * 
 * @author flaviolcastro
 *
 */
@Service
@Log4j2
public class CopyService {

  /**
   * Copy a queue.
   * 
   * @param original to be copied.
   * @return copied version
   */
  public <T> Queue<T> copy(Queue<T> original) {
    //
    log.debug("Copying queue: {}", original);
    // TODO: finish it
    return original;
  }

  /**
   * Copy a stack.
   * 
   * @param original to be copied.
   * @return copied version
   */
  public <T> Stack<T> copy(Stack<T> original) {
    //
    log.debug("Copying stack: {}", original);
    // TODO: finish it
    return original;
  }
  
  /**
   * Copy a bag.
   * 
   * @param original to be copied.
   * @return copied version
   */
  public <T> Bag<T> copy(Bag<T> original) {
    //
    log.debug("Copying bag: {}", original);
    // TODO: finish it
    return original;
  }

}
