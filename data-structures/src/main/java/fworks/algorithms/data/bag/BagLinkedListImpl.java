package fworks.algorithms.data.bag;

import fworks.algorithms.data.DataStructureLinkedList;
import lombok.extern.log4j.Log4j2;

/**
 * Bag implementation using Linked list.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class BagLinkedListImpl<T> extends DataStructureLinkedList<T> implements Bag<T> {

  @Override
  public void add(T item) {
    //
    log.debug("Adding item '{}' to the bag.", item);
    // sets the first as old
    Node<T> oldNode = firstNode;
    // create new
    Node<T> newNode = new Node<>(item, oldNode);
    // set new as first
    firstNode = newNode;
    // increment the number of items
    size++;
    //
    log.debug("Item '{}' added to the bag.", item);
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(","));
  }
}
