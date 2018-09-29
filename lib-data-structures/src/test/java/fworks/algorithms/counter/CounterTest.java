package fworks.algorithms.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CounterTest {

  @Test
  public void test() {
    Counter counter = new Counter();
    // test initial value
    assertEquals(0, counter.getCounter());
    // test one increment
    counter.increaseCounter();
    assertEquals(1, counter.getCounter());
  }
  
}
