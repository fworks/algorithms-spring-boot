package fworks.algorithms.data.queue;

import fworks.algorithms.data.DataStructureArray;
import lombok.extern.log4j.Log4j2;

/**
 * Queue implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class QueueArrayImpl<T> extends DataStructureArray<T> implements Queue<T> {

  @Override
  public void enqueue(T item) {
    //
    log.debug("Adding item '{}' to the queue.", item);
    // resize the array
    super.increaseArraySize(false);
    array[0] = item;
    //
    log.debug("Item '{}' added to the queue.", item);
  }

  @Override
  public T dequeue() {
    //
    if (isEmpty()) {
      //
      log.debug("Queue is empty. Nothing to dequeue.");
      return null;
    }
    //
    log.debug("Dequeue item from the queue.");
    // get the item
    T item = array[array.length - 1];
    // resize the array
    super.decreaseArraySize(true);
    //
    log.debug("Item '{}' dequeued from the queue.", item);
    return item;
  }
  
  @Override
  public T peek() {
    //
    if (isEmpty()) {
      //
      log.debug("Queue is empty. Nothing to peek.");
      return null;
    }
    //
    log.debug("Peeking the queue.");
    // get the item
    T item = array[array.length - 1];
    //
    log.debug("Item '{}' peeked from the queue.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" -> "));
  }
}
