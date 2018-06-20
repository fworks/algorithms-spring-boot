package fworks.algorithms.data.deque;

import fworks.algorithms.data.DataStructure;

/**
 * Deque.<br/>
 * A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but supports adding
 * and removing items at both ends.
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
  void pushRight(T item);

  /**
   * Add an item at the front of the deque.
   * 
   * @param item to be added
   */
  void pushLeft(T item);

  /**
   * Remove the last item of the deque.
   * 
   * @return last item
   */
  T popRight();

  /**
   * Remove the first item of the deque.
   * 
   * @return first item
   */
  T popLeft();
  
  /**
   * Peek the last item of the deque.
   * 
   * @return last item
   */
  T peekRight();

  /**
   * Peek the first item of the deque.
   * 
   * @return first item
   */
  T peekLeft();
}
