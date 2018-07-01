package fworks.algorithms.sorting.sort.quicksort;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.quicksort.QuicksortService;
import fworks.algorithms.sorting.sort.quicksort.QuicksortServiceImpl;
import org.junit.Before;

/**
 * Testing the QuicksortService.
 * 
 * @author flaviolcastro
 *
 */
public class QuicksortServiceTest extends AbstractSortingServiceTest {

  private QuicksortService sortingService;

  @Before
  public void setUp() {
    sortingService = new QuicksortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
