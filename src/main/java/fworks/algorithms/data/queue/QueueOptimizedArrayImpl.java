package fworks.algorithms.data.queue;

import fworks.algorithms.data.DataStructureOptimizedArray;
import lombok.extern.log4j.Log4j2;

/**
 * Queue implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class QueueOptimizedArrayImpl<T> extends DataStructureOptimizedArray<T> implements Queue<T> {

  @Override
  public void enqueue(T item) {
    //
    log.debug("Adding item '{}' to the queue.", item);
    // if array needs resizing
    if (array.length == size) {
      // resize the array doubling the size of it
      super.increaseArraySize(2 * array.length);
    }
    // add the new item
    int position = size++;
    array[position] = item;
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
    int position = index++;
    T item = array[position];
    array[position] = null;
    // size--;

    // if the size is a quarter of the array length - reduce the size of array
    if (array.length / 4 == size--) {
      // resize the array by half
      super.decreaseArraySize(array.length / 2);
    }
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
    T item = array[index];
    //
    log.debug("Item '{}' peeked from the queue.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" -> "));
  }
}
