package fworks.algorithms.problems;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class FibonacciServiceTest {

  private FibonacciService fibonacciService;

  @Before
  public void setUp() {
    fibonacciService = new FibonacciService();
  }

  @Test
  public void fibonacciFuntionTest() {
    Assert.assertEquals(0, fibonacciService.fibonacci(0));
    Assert.assertEquals(1, fibonacciService.fibonacci(1));
    Assert.assertEquals(1, fibonacciService.fibonacci(2));
    Assert.assertEquals(2, fibonacciService.fibonacci(3));
    Assert.assertEquals(3, fibonacciService.fibonacci(4));
    Assert.assertEquals(5, fibonacciService.fibonacci(5));
  }

  @Test
  public void calculateFibonacciSequenceTest() {
    long[] calculateFibonacci = fibonacciService.calculateFibonacciSequence(6);
    long[] expected = {0, 1, 1, 2, 3, 5};
    Assert.assertArrayEquals(expected, calculateFibonacci);
  }
  
  @Test
  public void calculateFibonacciSequenceTest2() {
    long[] calculateFibonacci = fibonacciService.calculateFibonacciSequence(50);
    log.info("Fibonacci: {}", calculateFibonacci);
  }
  
  @Test
  public void calculateFibonacciSequenceTest3() {
    long[] calculateFibonacci = fibonacciService.calculateFibonacciSequenceOptimized(5000);
    log.info("Fibonacci: {}", calculateFibonacci);
  }
}
