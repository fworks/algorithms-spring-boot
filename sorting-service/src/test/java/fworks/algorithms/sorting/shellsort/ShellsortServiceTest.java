package fworks.algorithms.sorting.shellsort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
import org.junit.Before;

/**
 * Testing the ShellsortService.
 * 
 * @author flaviolcastro
 *
 */
public class ShellsortServiceTest extends AbstractSortingServiceTest {

  private ShellsortService sortingService;

  @Before
  public void setUp() {
    sortingService = new ShellsortServiceImpl();
  }

  @Override
  protected SortingService getSortingService() {
    return sortingService;
  }
}
