package fworks.algorithms.data;

import java.lang.reflect.Array;
import java.util.Iterator;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Abstract class using linked list.<br>
 * Definition. A linked list is a recursive data structure that is either empty (null) or a
 * reference to a node having a generic item and a reference to a linked list.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public abstract class DataStructureLinkedList<T> implements DataStructure<T> {

  /**
   * First node.
   */
  protected Node<T> firstNode;
  /**
   * Number of items.
   */
  protected int size = 0;

  @Override
  public boolean isEmpty() {
    return firstNode == null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator(firstNode);
  }

  /**
   * Custom iterator for the linked list.
   * 
   * @author flaviolcastro
   *
   */
  private final class LinkedListIterator implements Iterator<T> {
    /**
     * current node.
     */
    Node<T> node;

    /**
     * Constructor.
     * 
     * @param firstNode node to start the iteration
     */
    public LinkedListIterator(Node<T> firstNode) {
      node = firstNode;
    }

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public T next() {
      // get the item
      T item = node.getItem();
      // move to the next
      node = node.getNext();
      return item;
    }
  }

  /**
   * Node of the list.
   * 
   * @author flaviolcastro
   *
   * @param <T> item
   */
  @Data
  @AllArgsConstructor
  protected static final class Node<T> {
    /**
     * item value.
     */
    private T item;
    /**
     * next node in the list.
     */
    private Node<T> next;
  }

  @Override
  public T[] toArray() {
    if(isEmpty()) {
      return null;
    }
    // type
    T first = this.firstNode.getItem();
    
    @SuppressWarnings("unchecked")
    T[] array = (T[]) Array.newInstance(first.getClass(), size());
    Iterator<T> iterator = this.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      array[i++] = iterator.next();
    }
    return array;
  }
}
