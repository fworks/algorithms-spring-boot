package fworks.algorithms.basics;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class NumberServiceImplTest {

  NumberService numberService;

  @Before
  public void setUp() {
    numberService = new NumberServiceImpl();
  }

  @Test
  public void isPrimeTest() {
    Assert.assertFalse(numberService.isPrime(0));
    Assert.assertFalse(numberService.isPrime(1));
    Assert.assertTrue(numberService.isPrime(2));
    Assert.assertTrue(numberService.isPrime(3));
    Assert.assertFalse(numberService.isPrime(4));
    Assert.assertTrue(numberService.isPrime(5));
    Assert.assertFalse(numberService.isPrime(6));
    Assert.assertTrue(numberService.isPrime(7));
    Assert.assertFalse(numberService.isPrime(8));
    Assert.assertFalse(numberService.isPrime(9));
    Assert.assertFalse(numberService.isPrime(10));


    Assert.assertTrue(numberService.isPrime(59));
    Assert.assertFalse(numberService.isPrime(60));

    Assert.assertTrue(numberService.isPrime(79));
    Assert.assertFalse(numberService.isPrime(69));

    Assert.assertTrue(numberService.isPrime(97));
    Assert.assertFalse(numberService.isPrime(99));
  }

  @Test
  public void findAllPrimesTest() {
    long[] findAllPrimes = numberService.findAllPrimes(100);
    long[] testResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97};
    Assert.assertArrayEquals(testResult,findAllPrimes);
    
    //   10,000  1,229
    long[] findAllPrimesTenThousands = this.validate(10_000, 1_229);
    log.debug(findAllPrimesTenThousands);
    //   100,000 9,592
    long[] findAllPrimesOneHundredThousand = this.validate(100_000, 9_592);
    log.debug(findAllPrimesOneHundredThousand);
  }

  private long[] validate(int maxNumber, int size) {
    long[] findAllPrimes = numberService.findAllPrimes(maxNumber);
    Assert.assertEquals(size, findAllPrimes.length, 0);
    return findAllPrimes;
  }
  
  @Test
  public void countAllPrimesTest() {
    long findAllPrimes = numberService.countAllPrimes(100);
    int[] testResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97};
    Assert.assertEquals(testResult.length, findAllPrimes, 0);
    
    //   10,000  1,229
    this.validateCount(10_000, 1_229);
    //   100,000 9,592
    this.validateCount(100_000, 9_592);
    //   1,000,000   78,498
    //this.validateCount(1_000_000, 78_498);
    //   10,000,000  664,579
    //this.validateCount(10_000_000, 664_579);
  }
  
  private void validateCount(int maxNumber, int size) {
    long findAllPrimes = numberService.countAllPrimes(maxNumber);
    Assert.assertEquals(size, findAllPrimes, 0);
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
    
    Assert.assertEquals(2, numberService.squareRootNewtons(4), 0);
    Assert.assertEquals(2, numberService.perfectSquareRoot(4), 0);
    Assert.assertEquals(3, numberService.squareRootNewtons(9), 0);
    Assert.assertEquals(3, numberService.perfectSquareRoot(9), 0);
    Assert.assertEquals(4, numberService.squareRootNewtons(16), 0);
    Assert.assertEquals(4, numberService.perfectSquareRoot(16), 0);
    Assert.assertEquals(5, numberService.squareRootNewtons(25), 0);
    Assert.assertEquals(5, numberService.perfectSquareRoot(25), 0);
    Assert.assertEquals(6, numberService.squareRootNewtons(36), 0);
    Assert.assertEquals(6, numberService.perfectSquareRoot(36), 0);
    
    Assert.assertEquals(5.477225575051661, numberService.squareRootNewtons(30), 0);
    Assert.assertEquals(Double.NaN, numberService.perfectSquareRoot(30), 0);
  }
  
  @Test
  public void getRightTrianguleHypotenuseTest() {
    double rightTrianguleHypotenuse = numberService.getRightTrianguleHypotenuse(4, 2);
    log.info(rightTrianguleHypotenuse);
    Assert.assertEquals(4.47, rightTrianguleHypotenuse, 0.01);
  }
  
  @Test
  public void getRightTrianguleAreaTest() {
    double rightTrianguleArea = numberService.getRightTrianguleArea(4, 2);
    log.info(rightTrianguleArea);
    Assert.assertEquals(4, rightTrianguleArea, 0.01);
  }
  
  @Test
  public void getRightTriangulePerimeterTest() {
    double rightTriangulePerimeter = numberService.getRightTriangulePerimeter(4, 2);
    log.info(rightTriangulePerimeter);
    Assert.assertEquals(10.47, rightTriangulePerimeter, 0.01);
  }
  
  @Test
  public void getGcdTest() {
    long gcd = numberService.getGcd(6, 8);
    log.info(gcd);
    Assert.assertEquals(2, gcd, 0);
    
    gcd = numberService.getGcd(25, 69);
    log.info(gcd);
    Assert.assertEquals(1, gcd, 0);
    
    gcd = numberService.getGcd(25, 100);
    log.info(gcd);
    Assert.assertEquals(25, gcd, 0);
    
    gcd = numberService.getGcd(1_111_111, 1_234_567);
    log.info(gcd);
    Assert.assertEquals(1, gcd, 0);

  }
}
