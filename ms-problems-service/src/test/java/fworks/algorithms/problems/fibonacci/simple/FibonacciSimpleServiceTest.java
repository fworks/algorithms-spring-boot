package fworks.algorithms.problems.fibonacci.simple;

import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;
import org.junit.Before;
import org.junit.Ignore;

public class FibonacciSimpleServiceTest extends FibonacciServiceTest {

  FibonacciSimpleService fibonacci;

  @Before
  public void setUp() {
    fibonacci = new FibonacciSimpleServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
  
  @Ignore
  public void calculateFibonacciSequenceLargeTest() {
  }

}
