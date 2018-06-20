package fworks.algorithms.problems.api;

import static org.mockito.Mockito.when;

import fworks.algorithms.problems.basics.NumberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PrimeControllerTest {

  private PrimeController primeController;

  private NumberService numberService;

  /**
   * Setting up mocking the services.
   */
  @Before
  public void setUp() {
    numberService = Mockito.mock(NumberService.class);
    primeController = new PrimeController(numberService);
  }

  @Test
  public void countAllPrimesUntilNumberTest() {
    int number = 1;
    long expected = 100L;
    when(numberService.countAllPrimes(number)).thenReturn(expected);

    long value = primeController.countAllPrimesUntilNumber(number);
    Assert.assertEquals(expected, value, 0);
  }

  @Test
  public void isPrimeTest() {
    int number = 1;
    when(numberService.isPrime(number)).thenReturn(true);

    boolean value = primeController.isPrime(number);
    Assert.assertTrue(value);
  }

}
