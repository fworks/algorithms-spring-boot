package fworks.algorithms.data;

import java.util.Iterator;
import lombok.extern.log4j.Log4j2;

/**
 * Abstract class using array.
 * 
 * @author flaviolcastro
 *
 * @param <T> item.
 */
@Log4j2
public abstract class DataStructureArray<T> implements DataStructure<T> {

  /**
   * Array that holds the items.
   */
  @SuppressWarnings("unchecked")
  protected T[] array = (T[]) new Object[0];

  @Override
  public boolean isEmpty() {
    // it is empty when the array is empty
    return array.length == 0;
  }

  @Override
  public int size() {
    // size is the array length
    return array.length;
  }
  
  /**
   * Increase the array size by 1.
   * @param atEnd true, to increase the array at the end (empty position(s) will be at the end)<br/>
   *        false, to increase the array at the beginning (empty position(s) will be at the start)
   */
  protected void increaseArraySize(boolean atEnd) {
    int oldSize = array.length;
    int newSize = oldSize + 1;
    log.debug("Increase array by 1 - old size: {} new size: {}", oldSize, newSize);
    @SuppressWarnings("unchecked")
    T[] newArray = (T[]) new Object[newSize];
    System.arraycopy(array, 0, newArray, (atEnd ? 0 : 1), oldSize);
    array = newArray;
  }
  
  /**
   * Decrease the array size by 1.
   * @param atEnd true, to decrease the array at the end (remove position at the end) <br/>
   *        false, to decrease the array at the beginning (remove position at the start)
   */
  protected void decreaseArraySize(boolean atEnd) {
    int oldSize = array.length;
    int newSize = oldSize - 1;
    log.debug("Decrease array by 1 - old size: {} new size: {}", oldSize, newSize);
    @SuppressWarnings("unchecked")
    T[] newArray = (T[]) new Object[newSize];
    System.arraycopy(array, (atEnd ? 0 : 1), newArray, 0, newSize);
    array = newArray;
  }
  
  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator(array);
  }
  
  /**
   * Custom iterator over the array.
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

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
      // get the item and move the position forward
      return (T) this.array[pos++];
    }
  }
  
  @Override
  public T[] toArray() {
    return this.array;
  }
}
