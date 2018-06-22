package fworks.algorithms.data.priorityqueue;

import fworks.algorithms.data.DataStructure;

/**
 * Priority Queue.<br>
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface PriorityQueue<T> extends DataStructure<T> {

  /**
   * Add a key in the priority queue.
   * @param item to be added
   */
  void insert(T item);

  /**
   * Return the largest key.
   */
  T max();

  /**
   * Return and remove the largest key.
   */
  T delMax();
}
