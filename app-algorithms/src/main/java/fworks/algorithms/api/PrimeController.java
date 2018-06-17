package fworks.algorithms.api;

import fworks.algorithms.basics.NumberService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = PrimeController.API)
public class PrimeController {

  protected static final String API = "/prime";

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
  @GetMapping("/isPrime")
  @ApiOperation("Verify if number is prime")
  public ResponseEntity<?> isPrime(Long number) {
    try {
      boolean result = numberService.isPrime(number);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  /**
   * Count the number of prime number between 1 and the number.
   * @param number limit
   * @return number of primes on the interval
   */
  @GetMapping("/countAllPrimesUntilNumber")
  public ResponseEntity<?> countAllPrimesUntilNumber(long number) {
    try {
      long result = numberService.countAllPrimes(number);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
