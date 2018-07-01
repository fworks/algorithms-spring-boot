package fworks.algorithms.problems.fibonacci.nonrecursive;

import fworks.algorithms.problems.fibonacci.FibonacciService;
import fworks.algorithms.problems.fibonacci.FibonacciServiceTest;
import org.junit.Before;

public class FibonacciNonRecursiveServiceTest extends FibonacciServiceTest {

  FibonacciNonRecursiveService fibonacci;

  @Before
  public void setUp() {
    fibonacci = new FibonacciNonRecursiveServiceImpl();
  }

  @Override
  protected FibonacciService getFibonacciService() {
    return fibonacci;
  }
}
