package fworks.algorithms.problems.api;

import fworks.algorithms.problems.basics.NumberService;
import javax.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API for prime number operations.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = PrimeController.API)
public class PrimeController {

  protected static final String API = "/prime";
  protected static final String IS_PRIME = "/isPrime";
  protected static final String COUNT_PRIME = "/countAllPrimesUntilNumber";

  private NumberService numberService;

  @Autowired
  public PrimeController(NumberService numberService) {
    this.numberService = numberService;
  }

  /**
   * Verify if number is prime.
   * 
   * @param number to be checked
   * @return true if prime, false otherwise
   */
  @GetMapping(IS_PRIME)
  public boolean isPrime(@NotNull long number) {
    log.info("Verifying if {} is prime.", number);
    return numberService.isPrime(number);
  }

  /**
   * Count the number of prime number between 1 and the number.
   * 
   * @param number limit
   * @return number of primes on the interval
   */
  @GetMapping(COUNT_PRIME)
  public long countAllPrimesUntilNumber(@NotNull long number) {
    log.info("Count all primes until number! Request {}", number);
    return numberService.countAllPrimes(number);
  }
}
