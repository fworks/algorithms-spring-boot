package fworks.algorithms.data.stack;

import fworks.algorithms.data.DataStructureLinkedList;
import lombok.extern.log4j.Log4j2;

/**
 * Stack implementation using linked list.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
@Log4j2
public class StackLinkedListImpl<T> extends DataStructureLinkedList<T> implements Stack<T> {

  @Override
  public void push(T item) {
    //
    log.debug("Pushing item '{}' to the stack.", item);
    // sets the first as old
    Node<T> oldNode = firstNode;
    // create new
    Node<T> newNode = new Node<>(item, oldNode);
    // set new as first
    firstNode = newNode;
    // increment the number of items
    size++;
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
    T item = firstNode.getItem();
    // remove the node, set the next as first
    firstNode = firstNode.getNext();
    // decrement the number of items
    size--;
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
    T item = firstNode.getItem();
    //
    log.debug("Item '{}' peeked from the stack.", item);
    return item;
  }

  @Override
  public String toString() {
    return String.format("[%s]", toString(" -> "));
  }
}
