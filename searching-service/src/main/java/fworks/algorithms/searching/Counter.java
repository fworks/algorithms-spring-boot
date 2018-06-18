package fworks.algorithms.searching;

import lombok.Getter;

@Getter
public class Counter {

  private int counter = 0;
  
  public void increaseCounter() {
    counter++;
  }
  
  public void decreaseCounter() {
    counter--;
  }
  
}
