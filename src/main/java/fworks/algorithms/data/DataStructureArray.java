package fworks.algorithms.data;

import java.util.Iterator;

/**
 * Abstract class using array.
 * 
 * @author flaviolcastro
 *
 * @param <T> item.
 */
public abstract class DataStructureArray<T> implements DataStructure<T> {

  /**
   * Array that holds the items.
   */
  protected Object[] array = {};

  @Override
  public boolean isEmpty() {
    // is empty when the array is empty
    return array.length == 0;
  }

  @Override
  public int size() {
    // size of the array
    return array.length;
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
}
