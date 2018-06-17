package fworks.algorithms.data.steque;

import fworks.algorithms.data.DataStructure;

/**
 * Steque.<br/>
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface Steque<T> extends DataStructure<T> {

  /**
   * Add an item at the back of the steque.
   * 
   * @param item to be added
   */
  void insertAtBack(T item);

  /**
   * Add an item at the front of the steque.
   * 
   * @param item to be added
   */
  void insertAtFront(T item);

  /**
   * Remove the last item of the steque.
   * 
   * @return last item
   */
  T removeLast();

  /**
   * Remove the first item of the steque.
   * 
   * @return first item
   */
  T removeFirst();
}
