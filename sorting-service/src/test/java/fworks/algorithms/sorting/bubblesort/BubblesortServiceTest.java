package fworks.algorithms.sorting.bubblesort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
import org.junit.Before;

/**
 * Testing the BubblesortService.
 * 
 * @author flaviolcastro
 *
 */
public class BubblesortServiceTest extends AbstractSortingServiceTest {

  private BubblesortService sortingService;

  @Before
  public void setUp() {
    sortingService = new BubblesortServiceImpl();
  }

  //@Override
  protected SortingService getSortingService() {
    return sortingService;
  }

}
