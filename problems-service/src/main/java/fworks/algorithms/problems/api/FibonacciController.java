package fworks.algorithms.problems.api;

import fworks.algorithms.problems.fibonacci.nonrecursive.FibonacciNonRecursiveService;
import fworks.algorithms.problems.fibonacci.optimized.FibonacciOptimizedService;
import fworks.algorithms.problems.fibonacci.simple.FibonacciSimpleService;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API for fibonacci.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = FibonacciController.API)
public class FibonacciController {

  protected static final String API = "/fibonacci";

  protected static final String FUNCTION_SIMPLE = "/functionSimple";
  protected static final String FUNCTION_NON_RECURSIVE = "/functionNonRecursive";
  protected static final String FUNCTION_OPTIMIZED = "/functionOptimized";

  protected static final String SEQUENCE_SIMPLE = "/sequenceSimple";
  protected static final String SEQUENCE_NON_RECURSIVE = "/sequenceNonRecursive";
  protected static final String SEQUENCE_OPTIMIZED = "/sequenceOptimized";

  private FibonacciNonRecursiveService fibonacciNonRecursiveService;
  private FibonacciSimpleService fibonacciSimpleService;
  private FibonacciOptimizedService fibonacciOptimizedService;

  /**
   * Constructor default.<br>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   * @param fibonacciNonRecursiveService non recursive service
   * @param fibonacciSimpleService simple service
   * @param fibonacciOptimizedService optimized service
   */
  @Autowired
  public FibonacciController(FibonacciNonRecursiveService fibonacciNonRecursiveService,
      FibonacciSimpleService fibonacciSimpleService,
      FibonacciOptimizedService fibonacciOptimizedService) {
    this.fibonacciNonRecursiveService = fibonacciNonRecursiveService;
    this.fibonacciSimpleService = fibonacciSimpleService;
    this.fibonacciOptimizedService = fibonacciOptimizedService;
  }

  /**
   * Execute fibonacci funtion.
   * 
   * @param number to be checked
   * @return fibonacci value
   */
  @GetMapping(FUNCTION_NON_RECURSIVE)
  public long fibonacciNonRecursiveFunction(@RequestParam @NotNull int number) {
    log.info("fibonacciNonRecursiveService function[{}]", number);
    return fibonacciNonRecursiveService.fibonacci(number);
  }

  /**
   * Execute fibonacci funtion.
   * 
   * @param number to be checked
   * @return fibonacci value
   */
  @GetMapping(FUNCTION_SIMPLE)
  public long fibonacciSimpleFunction(@RequestParam @NotNull int number) {
    log.info("fibonacciSimpleService function[{}]", number);
    if (number > 20) {
      throw new ValidationException("Number of Iterations cannot be greater than 20");
    }
    return fibonacciSimpleService.fibonacci(number);
  }

  /**
   * Execute fibonacci funtion.
   * 
   * @param number to be checked
   * @return fibonacci value
   */
  @GetMapping(FUNCTION_OPTIMIZED)
  public long fibonacciOptimizedFunction(@RequestParam @NotNull int number) {
    log.info("fibonacciOptimizedService function[{}]", number);
    // non recursive
    return fibonacciOptimizedService.fibonacci(number);
  }

  /**
   * Calculate the fibonacci sequence.
   * 
   * @param numberOfIterations number of iterations to calculate
   * @return fibonacci sequence
   */
  @GetMapping(SEQUENCE_SIMPLE)
  public long[] fibonacciSimpleSequence(@RequestParam int numberOfIterations) {
    log.info("fibonacciSimpleService sequence for {} iteration", numberOfIterations);
    if (numberOfIterations > 20) {
      throw new ValidationException("Number of Iterations cannot be greater than 20");
    }
    return fibonacciSimpleService.calculateFibonacciSequence(numberOfIterations);
  }

  /**
   * Calculate the fibonacci sequence.
   * 
   * @param numberOfIterations number of iterations to calculate
   * @return fibonacci sequence
   */
  @GetMapping(SEQUENCE_NON_RECURSIVE)
  public long[] fibonacciNonRecursiveSequence(@RequestParam int numberOfIterations) {
    log.info("fibonacciNonRecursiveService sequence for {} iteration", numberOfIterations);
    return fibonacciNonRecursiveService.calculateFibonacciSequence(numberOfIterations);
  }

  /**
   * Calculate the fibonacci sequence.
   * 
   * @param numberOfIterations number of iterations to calculate
   * @return fibonacci sequence
   */
  @GetMapping(SEQUENCE_OPTIMIZED)
  public long[] fibonacciOptimizedSequence(@RequestParam int numberOfIterations) {
    log.info("fibonacciOptimizedService sequence for {} iteration", numberOfIterations);
    return fibonacciOptimizedService.calculateFibonacciSequence(numberOfIterations);
  }
}
