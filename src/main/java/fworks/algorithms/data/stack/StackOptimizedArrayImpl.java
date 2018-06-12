package fworks.algorithms.data.stack;

import fworks.algorithms.data.DataStructureOptimizedArray;
import lombok.extern.log4j.Log4j2;

/**
 * Stack implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class StackOptimizedArrayImpl<T> extends DataStructureOptimizedArray<T> implements Stack<T> {

  @Override
  public void push(T item) {
    //
    log.debug("Pushing item '{}' to the stack.", item);
    // if array needs resizing
    if (array.length == size) {
      // resize the array doubling the size of it
      super.increaseArraySize(2 * array.length);
    }
    // add the new item at the last position
    //int position = (array.length - size++) - 1;
    array[size++] = item;
    //
    log.debug("Item '{}' pushed to the stack.", item);
  }

  @Override
  public T pop() {
    //
    if (isEmpty()) {
      //
      log.debug("Stack is empty. Nothing to pop.");
      return null;
    }
    //
    log.debug("Popping item from the stack.");
    // get the item
    int position = size-- - 1;
    @SuppressWarnings("unchecked")
    T item = (T) array[position];
    array[position] = null;
    // if the size is a quarter of the array length - reduce the size of array
    if (array.length / 4 == size) {
      // resize the array by half
      super.decreaseArraySize(array.length / 2);
    }
    //
    log.debug("Item '{}' popped from the stack.", item);
    return item;
  }
  
  @Override
  public T peek() {
    //
    if (isEmpty()) {
      //
      log.debug("Stack is empty. Nothing to peek.");
      return null;
    }
    //
    log.debug("Peeking item from the stack.");
    // get the item
    @SuppressWarnings("unchecked")
    T item = (T) array[size - 1];
    //
    log.debug("Item '{}' peeked from the stack.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" <- "));
  }
}
