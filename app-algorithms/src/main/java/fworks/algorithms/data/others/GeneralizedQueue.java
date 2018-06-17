package fworks.algorithms.data.others;

import fworks.algorithms.data.DataStructure;

/**
 * Generalized Queue.<br/>
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface GeneralizedQueue<T> extends DataStructure<T> {

  /**
   * Add an item.
   * 
   * @param item to be added
   */
  void insert(T item);

  /**
   * Delete and return the kth least recently inserted item.
   * 
   * @param k position
   * @return item
   */
  T delete(int k);

}
