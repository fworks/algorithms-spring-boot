package fworks.algorithms.problems.fibonacci.optimized;

import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;
import org.junit.Before;

public class FibonacciOptimizedServiceTest extends FibonacciServiceTest {

  FibonacciOptimizedService fibonacci;

  @Before
  public void setUp() {
    fibonacci = new FibonacciOptimizedServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
}
