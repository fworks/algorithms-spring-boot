package fworks.algorithms.data.deque;

import fworks.algorithms.data.DataStructureArray;
import lombok.extern.log4j.Log4j2;

/**
 * Deque implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class DequeArrayImpl<T> extends DataStructureArray<T> implements Deque<T> {

  @Override
  public void pushRight(T item) {
    //
    log.debug("Pushing item '{}' to the right of the deque.", item);
    // resize the array
    increaseArraySize(true);
    // add the new item at the last position
    array[array.length - 1] = item;
    //
    log.debug("Item '{}' pushed to the deque.", item);
  }

  @Override
  public void pushLeft(T item) {
    //
    log.debug("Pushing item '{}' to the left of the deque.", item);
    // resize the array
    increaseArraySize(false);
    // add the new item at the first position
    array[0] = item;
    //
    log.debug("Item '{}' pushed to the deque.", item);
  }

  @Override
  public T popRight() {
    //
    if (isEmpty()) {
      //
      log.debug("Deque is empty. Nothing to pop.");
      return null;
    }
    //
    log.debug("Popping item from the right of the deque.");
    // get the item
    T item = array[array.length - 1];
    // resize the array
    decreaseArraySize(true);
    //
    log.debug("Item '{}' popped from the deque.", item);
    return item;
  }

  @Override
  public T popLeft() {
    //
    if (isEmpty()) {
      //
      log.debug("Deque is empty. Nothing to pop.");
      return null;
    }
    //
    log.debug("Popping item from the left of the deque.");
    // get the item
    T item = array[0];
    // resize the array
    decreaseArraySize(false);
    //
    log.debug("Item '{}' popped from the deque.", item);
    return item;
  }
  
  @Override
  public T peekRight() {
    //
    if (isEmpty()) {
      //
      log.debug("Deque is empty. Nothing to peek.");
      return null;
    }
    //
    log.debug("Peeking item from the right of the deque.");
    // get the item
    T item = array[array.length - 1];
    //
    log.debug("Item '{}' peeked from the deque.", item);
    return item;
  }
  
  @Override
  public T peekLeft() {
    //
    if (isEmpty()) {
      //
      log.debug("Deque is empty. Nothing to peek.");
      return null;
    }
    //
    log.debug("Peeking item from the left of the deque.");
    // get the item
    T item = array[0];
    //
    log.debug("Item '{}' peeked from the deque.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(","));
  }
}
