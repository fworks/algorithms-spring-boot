package fworks.algorithms.data.queue;

import fworks.algorithms.data.DataStructureLinkedList;
import lombok.extern.log4j.Log4j2;

/**
 * Queue implementation using arrays.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class QueueLinkedListImpl<T> extends DataStructureLinkedList<T> implements Queue<T> {

  /**
   * Last node.
   */
  private Node<T> lastNode;

  @Override
  public void enqueue(T item) {
    //
    log.debug("Adding item '{}' to the queue.", item);
    if (firstNode == null) {
      firstNode = new Node<>(item, null);
      lastNode = firstNode;
    } else {
      // create new
      Node<T> newNode = new Node<>(item, null);
      // set as next of the lastNode
      lastNode.setNext(newNode);
      // set it as lastNode
      lastNode = newNode;
    }
    // increment the number of items
    size++;
    //
    log.debug("Item '{}' added to the queue.", item);
  }

  @Override
  public T dequeue() {
    //  
    log.debug("Dequeuing item from the queue.");
    // get the item
    T item = firstNode.getItem();
    // remove the node, set the next as first
    firstNode = firstNode.getNext();
    // decrement the number of items
    size--;
    // 
    log.debug("Item '{}' dequeued from the queue.", item);
    return item;
  }
  
  @Override
  public T peek() {
    //  
    log.debug("Peeking the queue.");
    //
    if (isEmpty()) {
      //
      log.debug("Queue is empty. Nothing to peek.");
      return null;
    }
    // get the item
    T item = firstNode.getItem();
    // 
    log.debug("Item '{}' peeked from the queue.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" -> "));
  }
}
