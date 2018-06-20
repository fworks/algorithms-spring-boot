package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
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
  protected SortingService getSortingService() {
    return sortingService;
  }
}
