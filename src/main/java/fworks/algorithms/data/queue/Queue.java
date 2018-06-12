package fworks.algorithms.data.queue;

import fworks.algorithms.data.DataStructure;

/**
 * Queue.<br/>
 * A FIFO queue is a collection that is based on the first-in-first-out (FIFO) policy.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface Queue<T> extends DataStructure<T> {

  /**
   * Add an item in the queue.
   * @param item to be added
   */
  void enqueue(T item);

  /**
   * Remove the least recently added item.
   * @return least recently added item
   */
  T dequeue();

}
