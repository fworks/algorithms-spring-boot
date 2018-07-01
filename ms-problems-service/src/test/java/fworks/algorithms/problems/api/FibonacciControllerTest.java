package fworks.algorithms.problems.api;

import static org.mockito.Mockito.when;

import fworks.algorithms.problems.fibonacci.nonrecursive.FibonacciNonRecursiveService;
import fworks.algorithms.problems.fibonacci.nonrecursive.FibonacciNonRecursiveServiceImpl;
import fworks.algorithms.problems.fibonacci.optimized.FibonacciOptimizedService;
import fworks.algorithms.problems.fibonacci.simple.FibonacciSimpleService;
import javax.validation.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FibonacciControllerTest {

  private FibonacciController fibonacciController;

  FibonacciNonRecursiveService fibonacciNonRecursiveService;
  FibonacciSimpleService fibonacciSimpleService;
  FibonacciOptimizedService fibonacciOptimizedService;

  /**
   * Setting up mocking the services.
   */
  @Before
  public void setUp() {
    fibonacciNonRecursiveService = Mockito.mock(FibonacciNonRecursiveServiceImpl.class);
    fibonacciSimpleService = Mockito.mock(FibonacciSimpleService.class);
    fibonacciOptimizedService = Mockito.mock(FibonacciOptimizedService.class);
    fibonacciController = new FibonacciController(fibonacciNonRecursiveService,
        fibonacciSimpleService, fibonacciOptimizedService);
  }

  @Test
  public void fibonacciNonRecursiveFunctionTest() {
    int number = 1;
    long expected = 1L;
    when(fibonacciNonRecursiveService.fibonacci(number)).thenReturn(expected);

    long value = fibonacciController.fibonacciNonRecursiveFunction(number);
    Assert.assertEquals(expected, value, 0);
  }

  @Test
  public void fibonacciOptimizedFunctionTest() {
    int number = 1;
    long expected = 1L;
    when(fibonacciOptimizedService.fibonacci(number)).thenReturn(expected);

    long value = fibonacciController.fibonacciOptimizedFunction(number);
    Assert.assertEquals(expected, value, 0);
  }

  @Test
  public void fibonacciSimpleFunctionTest() {
    int number = 1;
    long expected = 1L;
    when(fibonacciSimpleService.fibonacci(number)).thenReturn(expected);

    long value = fibonacciController.fibonacciSimpleFunction(number);
    Assert.assertEquals(expected, value, 0);
  }

  @Test
  public void fibonacciNonRecursiveSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciNonRecursiveService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciNonRecursiveSequence(number);
    Assert.assertArrayEquals(expected, value);
  }

  @Test
  public void fibonacciOptimizedSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciOptimizedService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciOptimizedSequence(number);
    Assert.assertArrayEquals(expected, value);
  }

  @Test
  public void fibonacciSimpleSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciSimpleService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciSimpleSequence(number);
    Assert.assertArrayEquals(expected, value);
  }

  @Test(expected = ValidationException.class)
  public void fibonacciSimpleSequenceLargeTest() {
    int number = 21;
    fibonacciController.fibonacciSimpleSequence(number);
  }

  @Test(expected = ValidationException.class)
  public void fibonacciSimpleFunctionLargeTest() {
    int number = 21;
    fibonacciController.fibonacciSimpleFunction(number);
  }

}
