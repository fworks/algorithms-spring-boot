package fworks.algorithms.problems.fibonacci.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;

public class FibonacciSimpleServiceTest extends FibonacciServiceTest {

  FibonacciSimpleService fibonacci;

  @BeforeEach
  public void setUp() {
    fibonacci = new FibonacciSimpleServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
  
  @Disabled
  public void calculateFibonacciSequenceLargeTest() {
  }

}
