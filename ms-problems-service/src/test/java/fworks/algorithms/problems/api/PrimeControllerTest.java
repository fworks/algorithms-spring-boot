package fworks.algorithms.problems.api;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import fworks.algorithms.problems.basics.NumberService;

@ExtendWith(MockitoExtension.class)
public class PrimeControllerTest {

  private PrimeController primeController;

  private NumberService numberService;

  /**
   * Setting up mocking the services.
   */
  @BeforeEach
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
    Assertions.assertEquals(expected, value);
  }

  @Test
  public void isPrimeTest() {
    int number = 1;
    when(numberService.isPrime(number)).thenReturn(true);

    boolean value = primeController.isPrime(number);
    Assertions.assertTrue(value);
  }

}
