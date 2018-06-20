package fworks.algorithms.sorting;

import java.util.Arrays;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

@Log4j2
public abstract class AbstractSortingServiceTest {

  protected void executeLongPrimitiveTest(SortingService sortingService) {
    long[] array = {10, 2, 5, 86, 99, 1, 6, 0};
    long[] sorted = {0, 1, 2, 5, 6, 10, 86, 99};
    SortingRequest request = new SortingRequest(array);
    SortingResponse sortResponse = sortingService.sort(request);
    log.info("Sorted: {}", sortResponse.getSortedArray());
    Assert.assertArrayEquals(sorted, sortResponse.getSortedArray());
  }
  
  protected void executeStringTest(SortingService sortingService) {
    String[] array = {"10", "2", "5", "86", "99", "1", "6", "0"};
    String[] sorted = {"0", "1", "10", "2", "5", "6", "86", "99"};
    log.info("Original: {}", Arrays.toString(array));
    String[] sort = (String[]) sortingService.sort(array, new Counter());
    log.info("Sorted: {}", Arrays.toString(array));
    Assert.assertArrayEquals(sorted, sort);
    
//    SortingRequest request = new SortingRequest(array);
//    SortingResponse sortResponse = selectionSortService.sort(request);
//    log.info("Sorted: {}", sortResponse.getSortedArray());
//    Assert.assertArrayEquals(sorted, sortResponse.getSortedArray());
  }
  
}
