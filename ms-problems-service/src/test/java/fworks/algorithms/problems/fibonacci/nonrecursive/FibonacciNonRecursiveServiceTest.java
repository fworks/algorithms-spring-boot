package fworks.algorithms.problems.fibonacci.nonrecursive;

import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;
import org.junit.jupiter.api.BeforeEach;

public class FibonacciNonRecursiveServiceTest extends FibonacciServiceTest {

  FibonacciNonRecursiveService fibonacci;

  @BeforeEach
  public void setUp() {
    fibonacci = new FibonacciNonRecursiveServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
}
