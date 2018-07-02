package fworks.algorithms.counter;

import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

  @Test
  public void test() {
    Counter counter = new Counter();
    // test initial value
    Assert.assertEquals(0, counter.getCounter(), 0);
    // test one increment
    counter.increaseCounter();
    Assert.assertEquals(1, counter.getCounter(), 0);
  }
  
}
