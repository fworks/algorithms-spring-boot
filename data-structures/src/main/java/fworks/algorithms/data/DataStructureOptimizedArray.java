package fworks.algorithms.data;

import java.lang.reflect.Array;
import java.util.Iterator;
import lombok.extern.log4j.Log4j2;

/**
 * Abstract class using array.<br>
 * Few optimizations like: reducing the number of array resizing
 * 
 * @author flaviolcastro
 *
 * @param <T> item.
 */
@Log4j2
public abstract class DataStructureOptimizedArray<T> implements DataStructure<T> {

  /**
   * Array that holds the items.
   */
  protected Object[] array = new Object[0];
  /**
   * Number of items.
   */
  protected int size = 0;

  /**
   * Index of the current element.
   */
  protected int index = 0;

  @Override
  public boolean isEmpty() {
    // is empty when size is 0
    return size == 0;
  }

  @Override
  public int size() {
    // size
    return size;
  }

  /**
   * Increase the array size to the new size.
   * 
   * @param newSize of the array
   */
  protected void increaseArraySize(int newSize) {
    int oldSize = array.length;
    // validate
    if (newSize <= 0) {
      //
      log.warn("Wrong value for increasing array: old size: {} new size: {}", oldSize, newSize);
      // TODO: maybe throw an exception
      return;
    }
    //
    log.debug("Increasing array size: old size: {} new size: {}", oldSize, newSize);
    // create new array
    @SuppressWarnings("unchecked")
    T[] newArray = (T[]) new Object[newSize];
    // copy values over
    System.arraycopy(array, 0, newArray, 0, oldSize);
    // update the array
    array = newArray;
  }

  /**
   * Decrease the array size to the new size.
   * 
   * @param newSize of the array
   */
  protected void decreaseArraySize(int newSize) {
    int oldSize = array.length;
    // validate
    if (newSize >= array.length || newSize < 0) {
      //
      log.warn("Wrong value for decreasing array: old size: {} new size: {}", oldSize, newSize);
      // TODO: maybe throw an exception
      return;
    }
    //
    log.debug("Decreasing array size: old size: {} new size: {}", oldSize, newSize);
    // create new array
    @SuppressWarnings("unchecked")
    T[] newArray = (T[]) new Object[newSize];

    // verify the index for copy the values over
    int copyFrom = 0;
    if (index >= newSize) {
      // if index is after the array middle
      copyFrom = newSize;
      // update the index
      index = index - newSize;
    } else {
      // if index is before the array middle
      copyFrom = index;
      // update the index
      index = 0;
    }
    // copy values over
    System.arraycopy(array, copyFrom, newArray, 0, newSize);
    // update the array
    array = newArray;
  }

  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator(array);
  }

  /**
   * Custom iterator over the array.
   * 
   * @author flaviolcastro
   *
   */
  private final class ArrayIterator implements Iterator<T> {
    /**
     * iterator position.
     */
    private int pos = 0;
    private Object[] array;

    /**
     * Constructor.
     * 
     * @param array to be iterate
     */
    public ArrayIterator(Object[] array) {
      this.array = array;
    }

    @Override
    public boolean hasNext() {
      // if not at the end
      return this.array.length > pos;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T next() {
      // get the item and move the position forward
      return (T) this.array[pos++];
    }
  }
  
  @Override
  public T[] toArray() {
    if(isEmpty()) {
      return null;
    }
    // type
    @SuppressWarnings("unchecked")
    T first = (T) this.array[0];
    
    @SuppressWarnings("unchecked")
    T[] array2 = (T[]) Array.newInstance(first.getClass(), array.length);
    System.arraycopy(array, 0, array2, 0, array.length);
    return array2;
  }
}
