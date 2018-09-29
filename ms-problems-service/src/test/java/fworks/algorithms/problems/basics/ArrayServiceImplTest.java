package fworks.algorithms.problems.basics;

import java.util.Comparator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class ArrayServiceImplTest {

  ArrayService arrayService;

  @BeforeEach
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
    Assertions.assertEquals(33.0, max.doubleValue());
  }

  @Test
  public void getMaxTest() {
    double[] array = {12.0, 2.0, 33.0, 0.3};
    double max = arrayService.getMax(array);
    log.info("Array: {} max: {}", array, max);
    Assertions.assertEquals(33.0, max);
  }
  
  @Test
  public void getMinTest() {
    double[] array = {12.0, 2.0, 33.0, 0.3};
    double max = arrayService.getMin(array);
    log.info("Array: {} min: {}", array, max);
    Assertions.assertEquals(0.3, max);
  }


  @Test
  public void getAvgTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double avg = arrayService.getAvg(array);
    log.info("Array: {} avg: {}", array, avg);
    Assertions.assertEquals(12.0, avg);
  }

  @Test
  public void getSumTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double sum = arrayService.getSum(array);
    log.info("Array: {} sum: {}", array, sum);
    Assertions.assertEquals(48.0, sum);
  }

  @Test
  public void reverseTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    double[] arrayReversed = {0.3, 33.0, 2.0, 12.7};
    double[] reversed = arrayService.reverse(array);
    log.info("Original array: {}", array);
    log.info("Reversed array: {}", reversed);
    Assertions.assertArrayEquals(arrayReversed, reversed);
  }
  
  @Test
  public void copyTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    log.info("Copying array: {}", array);
    double[] copy = arrayService.copy(array);
    log.info("Copied array: {}", copy);
    // validate equals
    Assertions.assertArrayEquals(array, copy);
    
    // change the original array
    array[0] = 0;
    // it shouldn't change the copy
    Assertions.assertNotEquals(array[0], copy[0]);
    log.info("Original array: {}", array);
    log.info("Copy array: {}", copy);
    
    // change the copied array
    copy[1] = 10;
    // it shouldn't change the original
    Assertions.assertNotEquals(copy[1], array[1]);
    log.info("Original array: {}", array);
    log.info("Copy array: {}", copy);
  }
  
  @Test
  public void isSortedTest() {
    double[] array = {12.7, 2.0, 33.0, 0.3};
    boolean sorted = arrayService.isSorted(array);
    log.info("Array: {} Sorted: {}", array, sorted);
    Assertions.assertFalse(sorted);
    
    double[] arraySorted = {12.7, 22.0, 33.0, 500.3};
    sorted = arrayService.isSorted(arraySorted);
    log.info("Array: {} Sorted: {}", arraySorted, sorted);
    Assertions.assertTrue(sorted);
  }
}
