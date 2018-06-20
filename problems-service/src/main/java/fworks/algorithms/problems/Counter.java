package fworks.algorithms.problems;

import lombok.Getter;

@Getter
public class Counter {

  private int counter = 0;
  
  public void increaseCounter() {
    counter++;
  }
  
}
