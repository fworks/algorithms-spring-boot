package fworks.algorithms.data.deque;

import fworks.algorithms.data.DataStructure;

/**
 * Deque.<br/>
 * A deque, also known as a double-ended queue, is an ordered collection of items similar to the
 * queue. It has two ends, a front and a rear, and the items remain positioned in the collection.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface Deque<T> extends DataStructure<T> {

  /**
   * Add an item at the back of the deque.
   * 
   * @param item to be added
   */
  void insertAtBack(T item);

  /**
   * Add an item at the front of the deque.
   * 
   * @param item to be added
   */
  void insertAtFront(T item);

  /**
   * Remove the last item of the deque.
   * 
   * @return last item
   */
  T removeLast();

  /**
   * Remove the first item of the deque.
   * 
   * @return first item
   */
  T removeFirst();
}
