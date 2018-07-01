package fworks.algorithms.problems.basics;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.stack.Stack;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Copy service.<br>
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
   * @throws Exception if something goes wrong
   */
  @SuppressWarnings("unchecked")
  public <T> Queue<T> copyQueue(Queue<T> original) throws Exception {
    //
    log.debug("Copying queue: {}", original);
    try {
      Queue<T> aux = original.getClass().getDeclaredConstructor().newInstance();
      original.forEach(t -> aux.enqueue(t));

      // using an aux queue - TODO: revisit it to improve that part
      Queue<T> copied = original.getClass().getDeclaredConstructor().newInstance();
      aux.forEach(t -> copied.enqueue(t));
      
      return copied;
    } catch (Exception e) {
      log.error("Error copying queue!", e);
      throw e;
    }
  }

  /**
   * Copy a stack.
   * 
   * @param original to be copied.
   * @return copied version
   * @throws Exception  if something goes wrong
   */
  public <T> Stack<T> copyStack(Stack<T> original) throws Exception {
    //
    log.debug("Copying stack: {}", original);
    try {
      @SuppressWarnings("unchecked")
      Stack<T> copied = original.getClass().getDeclaredConstructor().newInstance();
      original.forEach(t -> copied.push(t));
      return copied;
    } catch (Exception e) {
      log.error("Error copying stack!", e);
      throw e;
    }
  }

  /**
   * Copy a bag.
   * 
   * @param original to be copied.
   * @return copied version
   * @throws Exception  if something goes wrong
   */
  public <T> Bag<T> copyBag(Bag<T> original) throws Exception {
    //
    log.debug("Copying bag: {}", original);
    try {
      @SuppressWarnings("unchecked")
      Bag<T> copied = original.getClass().getDeclaredConstructor().newInstance();
      original.forEach(t -> copied.add(t));
      return copied;
    } catch (Exception e) {
      log.error("Error copying bag!", e);
      throw e;
    }
  }

}
