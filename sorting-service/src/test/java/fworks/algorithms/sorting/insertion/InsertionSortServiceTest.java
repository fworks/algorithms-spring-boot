package fworks.algorithms.sorting.insertion;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
import org.junit.Before;

/**
 * Testing the InsertionSortService.
 * 
 * @author flaviolcastro
 *
 */
public class InsertionSortServiceTest extends AbstractSortingServiceTest {

  private InsertionSortService sortingService;

  @Before
  public void setUp() {
    sortingService = new InsertionSortServiceImpl();
  }

  @Override
  protected SortingService getSortingService() {
    return sortingService;
  }

}
