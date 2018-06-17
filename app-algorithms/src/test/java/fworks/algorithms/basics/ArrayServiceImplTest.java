package fworks.algorithms.basics;

import java.util.Comparator;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class ArrayServiceImplTest {

  ArrayService arrayService;

  @Before
  public void setUp() {
    arrayService = new ArrayServiceImpl();
  }

  @Test
  public void getMaxGenericTest() {
    Double[] array = {12.0, 2.0, 33.0, 0.3};
    Double max = arrayService.getMax(array, new Comparator<Double>() {

      @Override
      public int compare(Double o1, Double o2) {
        return o1.compareTo(o2);
      }
    });
    log.info("Array: {} max: {}", array, max);
    Assert.assertEquals(33.0, max, 0);
  }

  @Test
  public void getMaxTest() {
    double[] array = {12.0, 2.0, 33.0, 0.3};
    double max = arrayService.getMax(array);
    log.info("Array: {} max: {}", array, max);
    Assert.assertEquals(33.0, max, 0);
  }
  
  @Test
  public void getMinTest() {
    double[] array = {12.0, 2.0, 33.0, 0.3};
    double max = arrayService.getMin(array);
    log.info("Array: {} min: {}", array, max);
    Assert.assertEquals(0.3, max, 0);
  }


  @Test
  public void getAvgTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double avg = arrayService.getAvg(array);
    log.info("Array: {} avg: {}", array, avg);
    Assert.assertEquals(12.0, avg, 0);
  }

  @Test
  public void getSumTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double sum = arrayService.getSum(array);
    log.info("Array: {} sum: {}", array, sum);
    Assert.assertEquals(48.0, sum, 0);
  }

  @Test
  public void reverseTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double[] arrayReversed = {0.3, 33.0, 2.0, 12.7};
    double[] reversed = arrayService.reverse(array);
    log.info("Original array: {}", array);
    log.info("Reversed array: {}", reversed);
    Assert.assertArrayEquals(arrayReversed, reversed, 0);
  }
  
  @Test
  public void copyTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    log.info("Copying array: {}", array);
    double[] copy = arrayService.copy(array);
    log.info("Copied array: {}", copy);
    // validate equals
    Assert.assertArrayEquals(array, copy, 0);
    
    // change the original array
    array[0] = 0;
    // it shouldn't change the copy
    Assert.assertNotEquals(array[0], copy[0]);
    log.info("Original array: {}", array);
    log.info("Copy array: {}", copy);
    
    // change the copied array
    copy[1] = 10;
    // it shouldn't change the original
    Assert.assertNotEquals(copy[1], array[1]);
    log.info("Original array: {}", array);
    log.info("Copy array: {}", copy);
  }
  
  @Test
  public void isSortedTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    boolean sorted = arrayService.isSorted(array);
    log.info("Array: {} Sorted: {}", array, sorted);
    Assert.assertFalse(sorted);
    
    double[] arraySorted = {12.7, 22.0, 33.0, 500.3};
    sorted = arrayService.isSorted(arraySorted);
    log.info("Array: {} Sorted: {}", arraySorted, sorted);
    Assert.assertTrue(sorted);
  }
}
