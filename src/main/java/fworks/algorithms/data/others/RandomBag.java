package fworks.algorithms.data.others;

import fworks.algorithms.data.bag.Bag;
import java.util.Iterator;

/**
 * RandomBag.<br/>
 * Based on: Write a class RandomBag that implements the same as for Bag, except for the adjective
 * random, which indicates that the iteration should provide the items in random order (all N!
 * permutations equally likely, for each iterator). Hint: Put the items in an array and randomize
 * their order in the iterator’s constructor.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public class RandomBag<T> implements Bag<T> {

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
  public void add(T item) {
    // TODO Auto-generated method stub
  }

  @Override
  public T[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

}
