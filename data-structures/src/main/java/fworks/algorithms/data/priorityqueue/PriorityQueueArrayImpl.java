package fworks.algorithms.data.priorityqueue;

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
public class PriorityQueueArrayImpl<T> extends DataStructureArray<T> implements PriorityQueue<T> {

  @Override
  public void insert(T item) {
    //
    log.debug("Inserting item '{}' to the priority queue.", item);
    // resize the array
    increaseArraySize(true);
    // add the new item at the last position
    array[array.length - 1] = item;
    //
    log.debug("Item '{}' inserted to the priority queue.", item);
  }

  @Override
  public T delMax() {
    //
    if (isEmpty()) {
      //
      log.debug("Priority queue is empty. Nothing to pop.");
      return null;
    }
    //
    log.debug("Popping item from the priority queue.");
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[array.length - 1];
    // resize the array
    decreaseArraySize(true);
    //
    log.debug("Item '{}' popped from the priority queue.", item);
    return item;
  }

  @Override
  public T max() {
    //
    if (isEmpty()) {
      //
      log.debug("Queue is empty. Nothing to peek.");
      return null;
    }
    //
    log.debug("Peeking the queue.");
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[array.length - 1];
    //
    log.debug("Item '{}' peeked from the queue.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" -> "));
  }
}
