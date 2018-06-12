package fworks.algorithms.data.stack;

import fworks.algorithms.data.DataStructure;

/**
 * Stack.<br/>
 * A pushdown stack is a collection that is based on the last-in-first-out (LIFO) policy
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface Stack<T> extends DataStructure<T> {

  /**
   * Add an item in the stack.
   * @param item to be added
   */
  void push(T item);

  /**
   * Remove the least recently added item.
   * @return least recently added item
   */
  T pop();

  /**
   * Return the least recently added item, without removing it from the stack.
   * @return least recently added item
   */
  T peek();
}
