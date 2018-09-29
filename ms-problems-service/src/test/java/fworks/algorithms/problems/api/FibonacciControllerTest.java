package fworks.algorithms.problems.api;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import javax.validation.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import fworks.algorithms.problems.fibonacci.nonrecursive.FibonacciNonRecursiveService;
import fworks.algorithms.problems.fibonacci.nonrecursive.FibonacciNonRecursiveServiceImpl;
import fworks.algorithms.problems.fibonacci.optimized.FibonacciOptimizedService;
import fworks.algorithms.problems.fibonacci.simple.FibonacciSimpleService;

@ExtendWith(MockitoExtension.class)
public class FibonacciControllerTest {

  private FibonacciController fibonacciController;

  FibonacciNonRecursiveService fibonacciNonRecursiveService;
  FibonacciSimpleService fibonacciSimpleService;
  FibonacciOptimizedService fibonacciOptimizedService;

  /**
   * Setting up mocking the services.
   */
  @BeforeEach
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
    Assertions.assertEquals(expected, value);
  }

  @Test
  public void fibonacciOptimizedFunctionTest() {
    int number = 1;
    long expected = 1L;
    when(fibonacciOptimizedService.fibonacci(number)).thenReturn(expected);

    long value = fibonacciController.fibonacciOptimizedFunction(number);
    Assertions.assertEquals(expected, value);
  }

  @Test
  public void fibonacciSimpleFunctionTest() {
    int number = 1;
    long expected = 1L;
    when(fibonacciSimpleService.fibonacci(number)).thenReturn(expected);

    long value = fibonacciController.fibonacciSimpleFunction(number);
    Assertions.assertEquals(expected, value);
  }

  @Test
  public void fibonacciNonRecursiveSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciNonRecursiveService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciNonRecursiveSequence(number);
    Assertions.assertArrayEquals(expected, value);
  }

  @Test
  public void fibonacciOptimizedSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciOptimizedService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciOptimizedSequence(number);
    Assertions.assertArrayEquals(expected, value);
  }

  @Test
  public void fibonacciSimpleSequenceTest() {
    int number = 1;
    long[] expected = {0, 0, 1};
    when(fibonacciSimpleService.calculateFibonacciSequence(number)).thenReturn(expected);

    long[] value = fibonacciController.fibonacciSimpleSequence(number);
    Assertions.assertArrayEquals(expected, value);
  }

  @Test
  public void fibonacciSimpleSequenceLargeTest() {
    assertThrows(ValidationException.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        int number = 21;
        fibonacciController.fibonacciSimpleSequence(number);
      }
    });
  }

  @Test
  public void fibonacciSimpleFunctionLargeTest() {
    assertThrows(ValidationException.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        int number = 21;
        fibonacciController.fibonacciSimpleFunction(number);
      }
    });
  }

}
