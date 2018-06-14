package fworks.algorithms.basics;

import fworks.algorithms.basics.NumberServiceImpl;
import fworks.algorithms.data.bag.Bag;
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
    Bag<Integer> findAllPrimes = numberService.findAllPrimes(100);
    int[] testResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97};
    Assert.assertEquals(testResult.length,findAllPrimes.size(), 0);
    
    
    //   10,000  1,229
    Bag<Integer> findAllPrimesTenThousands = this.validate(10_000, 1_229);
    log.debug(findAllPrimesTenThousands);
    //   100,000 9,592
    Bag<Integer> findAllPrimesOneHundredThousand = this.validate(100_000, 9_592);
    log.debug(findAllPrimesOneHundredThousand);
  }

  private Bag<Integer> validate(int maxNumber, int size) {
    Bag<Integer> findAllPrimes = numberService.findAllPrimes(maxNumber);
    Assert.assertEquals(size, findAllPrimes.size(), 0);
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
    this.validateCount(1_000_000, 78_498);
    //   10,000,000  664,579
    this.validateCount(10_000_000, 664_579);
  }
  
  private void validateCount(int maxNumber, int size) {
    long findAllPrimes = numberService.countAllPrimes(maxNumber);
    Assert.assertEquals(size, findAllPrimes, 0);
  }
  
  @Test
  public void squareRootTest() {
    log.info(numberService.factor(0));
    log.info(numberService.factor(1));
    log.info(numberService.factor(2));
    log.info(numberService.factor(3));
    log.info(numberService.factor(4));
    log.info(numberService.factor(8));
    log.info(numberService.factor(10));
    log.info(numberService.factor(12));
    
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
}
