package fworks.algorithms.data.bag;

import fworks.algorithms.data.DataStructureOptimizedArray;
import lombok.extern.log4j.Log4j2;

/**
 * Bag implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class BagOptimizedArrayImpl<T> extends DataStructureOptimizedArray<T> implements Bag<T> {

  @Override
  public void add(T item) {
    //
    log.debug("Adding item '{}' to the bag.", item);
    // if array needs resizing
    if (array.length == size) {
      // resize the array doubling the size of it
      int newSize = 2 * (array.length == 0 ? 1 : array.length);
      super.increaseArraySize(newSize);
    }
    // add the new item
    array[size++] = item;
    //
    log.debug("Item '{}' added to the bag.", item);
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(","));
  }
}
