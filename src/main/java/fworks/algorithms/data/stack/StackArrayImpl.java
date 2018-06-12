package fworks.algorithms.data.stack;

import fworks.algorithms.data.DataStructureArray;
import lombok.extern.log4j.Log4j2;

/**
 * Stack implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class StackArrayImpl<T> extends DataStructureArray<T> implements Stack<T> {

  @Override
  public void push(T item) {
    //
    log.debug("Pushing item '{}' to the stack.", item);
    // resize the array
    Object[] newArray = new Object[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);
    array = newArray;
    // add the new item
    array[array.length - 1] = item;
    //
    log.debug("Item '{}' pushed to the stack.", item);
  }

  @Override
  public T pop() {
    //
    log.debug("Popping item from the stack.");
    //
    if (isEmpty()) {
      //
      log.debug("Stack is empty. Nothing to pop.");
      return null;
    }
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[array.length - 1];
    // resize the array
    Object[] newArray = new Object[array.length - 1];
    System.arraycopy(array, 0, newArray, 0, array.length - 1);
    array = newArray;
    //
    log.debug("Item '{}' popped from the stack.", item);
    return item;
  }
  
  @Override
  public T peek() {
    //
    log.debug("Peeking item from the stack.");
    //
    if (isEmpty()) {
      //
      log.debug("Stack is empty. Nothing to peek.");
      return null;
    }
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[array.length - 1];
    //
    log.debug("Item '{}' peeked from the stack.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" <- "));
  }
}
