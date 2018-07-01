package fworks.algorithms.data.bag;

import fworks.algorithms.data.DataStructureArray;
import lombok.extern.log4j.Log4j2;

/**
 * Bag implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class BagArrayImpl<T> extends DataStructureArray<T> implements Bag<T> {

  @Override
  public void add(T item) {
    //
    log.debug("Adding item '{}' to the bag.", item);
    // resize the array
    increaseArraySize(true);
    // add the new item
    array[array.length - 1] = item;
    //
    log.debug("Item '{}' added to the bag.", item);
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(","));
  }
}
