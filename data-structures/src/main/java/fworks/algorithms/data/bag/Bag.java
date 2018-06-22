package fworks.algorithms.data.bag;

import fworks.algorithms.data.DataStructure;

/**
 * Bag.<br>
 * A bag is a collection where removing items is not supported — its purpose is to provide clients
 * with the ability to collect items and then to iterate through the collected items.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface Bag<T> extends DataStructure<T> {

  /**
   * Add an item in the bag.
   * 
   * @param item to be added
   */
  void add(T item);

}
