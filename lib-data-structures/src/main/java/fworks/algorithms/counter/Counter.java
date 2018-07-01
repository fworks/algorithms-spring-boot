package fworks.algorithms.counter;

import lombok.Getter;

/**
 * Auxiliary counter.
 * 
 * @author flaviolcastro
 *
 */
@Getter
public class Counter {

  /**
   * hold the number of counts.
   */
  private int counter = 0;

  /**
   * Increase the counter.
   */
  public void increaseCounter() {
    counter++;
  }

}
