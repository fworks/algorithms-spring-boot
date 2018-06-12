package fworks.algorithms.data.others;

import fworks.algorithms.data.queue.Queue;
import java.util.Iterator;

/**
 * Random Queue.<br/>
 * Based on: Write a class RandomQueue that implements this API. Hint: Use an array representation
 * (with resizing). To remove an item, swap one at a random position (indexed 0 through N-1) with
 * the one at the last position (index N-1). Then delete and return the last object, as in
 * ResizingArrayStack. Write a client that deals bridge hands (13 cards each) using
 * RandomQueue of Card. 
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public class RandomQueue<T> implements Queue<T> {

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void enqueue(T item) {
    // TODO Auto-generated method stub

  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T peek() {
    // TODO Auto-generated method stub
    return null;
  }

}
