package fworks.algorithms.problems.fibonacci;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Log4j2
public abstract class FibonacciServiceTest {

  protected abstract FibonacciService getFibonacciService();
  
  @Test
  public void fibonacciFuntionTest() {
    Assertions.assertEquals(0, getFibonacciService().fibonacci(0));
    Assertions.assertEquals(1, getFibonacciService().fibonacci(1));
    Assertions.assertEquals(1, getFibonacciService().fibonacci(2));
    Assertions.assertEquals(2, getFibonacciService().fibonacci(3));
    Assertions.assertEquals(3, getFibonacciService().fibonacci(4));
    Assertions.assertEquals(5, getFibonacciService().fibonacci(5));
  }

  @Test
  public void calculateFibonacciSequenceTest() {
    long[] calculateFibonacci = getFibonacciService().calculateFibonacciSequence(6);
    long[] expected = {0, 1, 1, 2, 3, 5};
    Assertions.assertArrayEquals(expected, calculateFibonacci);
  }
  
  @Test
  public void calculateFibonacciSequenceMediumTest() {
    long[] calculateFibonacci = getFibonacciService().calculateFibonacciSequence(15);
    log.info("Fibonacci: {}", calculateFibonacci);
  }
  
  @Test
  public void calculateFibonacciSequenceLargeTest() {
    long[] calculateFibonacci = getFibonacciService().calculateFibonacciSequence(5000);
    log.info("Fibonacci: {}", calculateFibonacci);
  }
}
