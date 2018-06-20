package fworks.algorithms.sorting.selection;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
import org.junit.Before;

/**
 * Testing the SelectionSortService.
 * 
 * @author flaviolcastro
 *
 */
public class SelectionSortServiceTest extends AbstractSortingServiceTest {

  private SelectionSortService sortingService;

  @Before
  public void setUp() {
    sortingService = new SelectionSortServiceImpl();
  }

  @Override
  protected SortingService getSortingService() {
    return sortingService;
  }
}
