package fworks.algorithms.problems.fibonacci.optimized;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;

public class FibonacciOptimizedServiceTest extends FibonacciServiceTest {

  FibonacciOptimizedService fibonacci;

  @BeforeEach
  public void setUp() {
    fibonacci = new FibonacciOptimizedServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
}
