package fworks.algorithms.sorting;

import fworks.algorithms.api.model.Counter;
import java.util.Arrays;
import java.util.Random;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;

/**
 * Common tests for sorting services.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractSortingServiceTest {

  /**
   * Execute test over a long[].
   * 
   * @param sortingService service to test
   */
  protected void executeLongPrimitiveTest(SortingService sortingService) {
    long[] array = {10, 2, 5, 86, 99, 1, 6, 0};
    long[] sorted = {0, 1, 2, 5, 6, 10, 86, 99};
    this.validateSorting(sortingService, array, sorted);
  }

  /**
   * Execute test over a String array.
   * 
   * @param sortingService service to test
   */
  protected void executeStringTest(SortingService sortingService) {
    String[] array = {"10", "2", "5", "86", "99", "1", "6", "0"};
    String[] sorted = {"0", "1", "10", "2", "5", "6", "86", "99"};
    this.validateSorting(sortingService, array, sorted);
  }

  /**
   * Execute test over a String array.
   * 
   * @param sortingService service to test
   */
  protected void executeWordTest(SortingService sortingService) {
    String[] array = {"verifing", "if", "the", "sorting", "service", "is", "working", "!"};
    String[] sorted = {"!", "if", "is", "service", "sorting", "the", "verifing", "working"};
    this.validateSorting(sortingService, array, sorted);
  }

  /**
   * Execute test over a Double array.
   * 
   * @param sortingService service to test
   */
  protected void executeDoubleTest(SortingService sortingService) {
    Double[] array = {10.0, 2.23, 5.63, 0.0021, 86.789, 99.1, 1.0001, 6.3, 0.002, 0.003};
    Double[] sorted = {0.002, 0.0021, 0.003, 1.0001, 2.23, 5.63, 6.3, 10.0, 86.789, 99.1};
    this.validateSorting(sortingService, array, sorted);
  }
  
  /**
   * Execute test over a medium array.
   * 
   * @param sortingService service to test
   */
  protected void executeMediumSizeArrayTest(SortingService sortingService) {
    Random random = new Random();

    // create the arrays for sorting
    int size = 400;
    // primitive
    long[] array = random.ints(0, size).limit(size).asLongStream().toArray();
    // comparable
    Long[] arrayLong = new Long[size]; 
    for (int i = 0; i < array.length; i++) {
      arrayLong[i] = array[i];
    }
    
    // get the sorted for comparing
    // primitive
    long[] sorted = new long[size];
    System.arraycopy(array, 0, sorted, 0, size);
    Arrays.sort(sorted);
    // comparable
    Long[] sorted2 = new Long[size];
    System.arraycopy(arrayLong, 0, sorted2, 0, size);
    Arrays.sort(sorted2);
    
    // validate primitive
    this.validateSorting(sortingService, array, sorted);
    // validate comparable
    this.validateSorting(sortingService, arrayLong, sorted2);
  }
  
  /**
   * Validate sorting.
   * 
   * @param sortingService service to test
   * @param array original
   * @param sorted expected
   */
  private void validateSorting(SortingService sortingService, long[] array,
      long[] sorted) {
    log.info("Original: {}", Arrays.toString(array));
    log.info("Expected: {}", Arrays.toString(sorted));
    long[] sort = sortingService.sort(array, new Counter());
    log.info("Sorted: {}", Arrays.toString(array));
    Assert.assertArrayEquals(sorted, sort);
  }

  /**
   * Validate sorting.
   * 
   * @param sortingService service to test
   * @param array original
   * @param sorted expected
   */
  private void validateSorting(SortingService sortingService, Comparable<?>[] array,
      Comparable<?>[] sorted) {
    log.info("Original: {}", Arrays.toString(array));
    log.info("Expected: {}", Arrays.toString(sorted));
    Comparable<?>[] sort = sortingService.sort(array, new Counter());
    log.info("Sorted: {}", Arrays.toString(array));
    Assert.assertArrayEquals(sorted, sort);
  }

  /**
   * Get the sorting service.
   * 
   * @return Sorting service to be test
   */
  protected abstract SortingService getSortingService();

  /**
   * Test for long[]
   */
  @Test
  public void executeLongPrimitiveTest() {
    executeLongPrimitiveTest(getSortingService());
  }

  /**
   * Test for String[]
   */
  @Test
  public void executeStringTest() {
    executeStringTest(getSortingService());
  }

  /**
   * Test for String[]
   */
  @Test
  public void executeWordTest() {
    executeWordTest(getSortingService());
  }

  /**
   * Test for Double[]
   */
  @Test
  public void executeDoubleTest() {
    executeDoubleTest(getSortingService());
  }
  
  /**
   * Test for Long[]
   */
  @Test
  public void executeLongTest() {
    executeMediumSizeArrayTest(getSortingService());
  }

}
