package fworks.algorithms.problems.basics;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class NumberServiceImplTest {

  NumberService numberService;

  @BeforeEach
  public void setUp() {
    numberService = new NumberServiceImpl();
  }
  
  @Test
  public void getAbsTest() {
    Assertions.assertEquals(12, numberService.getAbs(-12.0));
    Assertions.assertEquals(12, numberService.getAbs(12.0));
    Assertions.assertEquals(12, numberService.getAbs(-12L));
    Assertions.assertEquals(12, numberService.getAbs(12L));
  }
  
  @Test
  public void getNumberDivisorsTest() {
    long[] divisors = {12, 6, 4, 3, 2, 1};
    Assertions.assertArrayEquals(divisors, numberService.getNumberDivisors(12));
    Assertions.assertNull(numberService.getNumberDivisors(-12));
  }

  @Test
  public void isPrimeTest() {
    Assertions.assertFalse(numberService.isPrime(0));
    Assertions.assertFalse(numberService.isPrime(1));
    Assertions.assertTrue(numberService.isPrime(2));
    Assertions.assertTrue(numberService.isPrime(3));
    Assertions.assertFalse(numberService.isPrime(4));
    Assertions.assertTrue(numberService.isPrime(5));
    Assertions.assertFalse(numberService.isPrime(6));
    Assertions.assertTrue(numberService.isPrime(7));
    Assertions.assertFalse(numberService.isPrime(8));
    Assertions.assertFalse(numberService.isPrime(9));
    Assertions.assertFalse(numberService.isPrime(10));


    Assertions.assertTrue(numberService.isPrime(59));
    Assertions.assertFalse(numberService.isPrime(60));

    Assertions.assertTrue(numberService.isPrime(79));
    Assertions.assertFalse(numberService.isPrime(69));

    Assertions.assertTrue(numberService.isPrime(97));
    Assertions.assertFalse(numberService.isPrime(99));
  }

  @Test
  public void findAllPrimesTest() {
    long[] findAllPrimes = numberService.findAllPrimes(100);
    long[] testResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97};
    Assertions.assertArrayEquals(testResult,findAllPrimes);
    
    //   10,000  1,229
    long[] findAllPrimesTenThousands = this.validate(10_000, 1_229);
    log.debug(findAllPrimesTenThousands);
    //   100,000 9,592
    //long[] findAllPrimesOneHundredThousand = this.validate(100_000, 9_592);
    //log.debug(findAllPrimesOneHundredThousand);
  }

  private long[] validate(int maxNumber, int size) {
    long[] findAllPrimes = numberService.findAllPrimes(maxNumber);
    Assertions.assertEquals(size, findAllPrimes.length);
    return findAllPrimes;
  }
  
  @Test
  public void countAllPrimesTest() {
    long findAllPrimes = numberService.countAllPrimes(100);
    int[] testResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97};
    Assertions.assertEquals(testResult.length, findAllPrimes);
    
    //   10,000  1,229
    this.validateCount(10_000, 1_229);
    //   100,000 9,592
    //this.validateCount(100_000, 9_592);
    //   1,000,000   78,498
    //this.validateCount(1_000_000, 78_498);
    //   10,000,000  664,579
    //this.validateCount(10_000_000, 664_579);
  }
  
  private void validateCount(int maxNumber, int size) {
    long findAllPrimes = numberService.countAllPrimes(maxNumber);
    Assertions.assertEquals(size, findAllPrimes);
  }
  
  @Test
  public void squareRootTest() {
    log.info(numberService.primeFactor(0));
    log.info(numberService.primeFactor(1));
    log.info(numberService.primeFactor(2));
    log.info(numberService.primeFactor(3));
    log.info(numberService.primeFactor(4));
    log.info(numberService.primeFactor(8));
    log.info(numberService.primeFactor(10));
    log.info(numberService.primeFactor(12));
    
    Assertions.assertEquals(2, numberService.squareRootNewtons(4));
    Assertions.assertEquals(2, numberService.perfectSquareRoot(4));
    Assertions.assertEquals(3, numberService.squareRootNewtons(9));
    Assertions.assertEquals(3, numberService.perfectSquareRoot(9));
    Assertions.assertEquals(4, numberService.squareRootNewtons(16));
    Assertions.assertEquals(4, numberService.perfectSquareRoot(16));
    Assertions.assertEquals(5, numberService.squareRootNewtons(25));
    Assertions.assertEquals(5, numberService.perfectSquareRoot(25));
    Assertions.assertEquals(6, numberService.squareRootNewtons(36));
    Assertions.assertEquals(6, numberService.perfectSquareRoot(36));
    
    Assertions.assertEquals(Double.NaN, numberService.squareRootNewtons(-36));
    Assertions.assertEquals(Double.NaN, numberService.perfectSquareRoot(-36));
    
    Assertions.assertEquals(1, numberService.squareRootNewtons(1));
    Assertions.assertEquals(1, numberService.perfectSquareRoot(1));
    
    Assertions.assertEquals(5.477225575051661, numberService.squareRootNewtons(30));
    Assertions.assertEquals(Double.NaN, numberService.perfectSquareRoot(30));
  }
  
  @Test
  public void getRightTrianguleHypotenuseTest() {
    double rightTrianguleHypotenuse = numberService.getRightTrianguleHypotenuse(4, 2);
    log.info(rightTrianguleHypotenuse);
    Assertions.assertEquals(4.47, rightTrianguleHypotenuse, 0.01);
  }
  
  @Test
  public void getRightTrianguleAreaTest() {
    double rightTrianguleArea = numberService.getRightTrianguleArea(4, 2);
    log.info(rightTrianguleArea);
    Assertions.assertEquals(4, rightTrianguleArea, 0.01);
  }
  
  @Test
  public void getRightTriangulePerimeterTest() {
    double rightTriangulePerimeter = numberService.getRightTriangulePerimeter(4, 2);
    log.info(rightTriangulePerimeter);
    Assertions.assertEquals(10.47, rightTriangulePerimeter, 0.01);
  }
  
  @Test
  public void getGcdTest() {
    long gcd = numberService.getGcd(6, 8);
    log.info(gcd);
    Assertions.assertEquals(2, gcd);
    
    gcd = numberService.getGcd(25, 69);
    log.info(gcd);
    Assertions.assertEquals(1, gcd);
    
    gcd = numberService.getGcd(25, 100);
    log.info(gcd);
    Assertions.assertEquals(25, gcd);
    
    gcd = numberService.getGcd(1_111_111, 1_234_567);
    log.info(gcd);
    Assertions.assertEquals(1, gcd);

  }
  
  @Test
  public void getLcmTest() {
    long lcm = numberService.getLcm(6, 8);
    log.info(lcm);
    Assertions.assertEquals(24, lcm);
    
    lcm = numberService.getLcm(25, 69);
    log.info(lcm);
    Assertions.assertEquals(1725, lcm);
    
    lcm = numberService.getLcm(25, 100);
    log.info(lcm);
    Assertions.assertEquals(100, lcm);
  }
}
