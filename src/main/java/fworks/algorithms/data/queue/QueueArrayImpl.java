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
    Object[] newArray = new Object[array.length + 1];
    newArray[0] = item;
    System.arraycopy(array, 0, newArray, 1, array.length);
    array = newArray;
    //
    log.debug("Item '{}' added to the queue.", item);
  }

  @Override
  public T dequeue() {
    //
    log.debug("Dequeue item from the queue.");
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[array.length - 1];
    // resize the array
    Object[] newArray = new Object[array.length - 1];
    System.arraycopy(array, 0, newArray, 0, array.length - 1);
    array = newArray;
    //
    log.debug("Item '{}' dequeued from the queue.", item);
    return item;
  }
  
  @Override
  public T peek() {
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
