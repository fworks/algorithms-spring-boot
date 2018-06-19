package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.Counter;
import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class Quick3wayServiceTest {

  private Quick3wayService sortService;

  @Before
  public void setUp() {
    sortService = new Quick3wayServiceImpl();
  }

  @Test
  public void commonTest() {
    long[] array = {10, 2, 5, 86, 99, 1, 6, 0};
    long[] sorted = {0, 1, 2, 5, 6, 10, 86, 99};
    SortingRequest request = new SortingRequest(array);
    SortingResponse sortResponse = sortService.sort(request);
    log.info("Sorted: {}", sortResponse.getSortedArray());
    Assert.assertArrayEquals(sorted, sortResponse.getSortedArray());
  }
  
  @Test
  public void common2Test() {
    String[] array = {"10", "2", "5", "86", "99", "1", "6", "0"};
    String[] sorted = {"0", "1", "10", "2", "5", "6", "86", "99"};
    log.info("Original: {}", Arrays.toString(array));
    String[] sort = (String[]) sortService.sort(array, new Counter());
    log.info("Sorted: {}", Arrays.toString(array));
    Assert.assertArrayEquals(sorted, sort);
    
//    SortingRequest request = new SortingRequest(array);
//    SortingResponse sortResponse = selectionSortService.sort(request);
//    log.info("Sorted: {}", sortResponse.getSortedArray());
//    Assert.assertArrayEquals(sorted, sortResponse.getSortedArray());
  }
}
