package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
import org.junit.Before;

/**
 * Testing the Quick3wayService.
 * 
 * @author flaviolcastro
 *
 */
public class Quick3wayServiceTest extends AbstractSortingServiceTest {

  private Quick3wayService sortingService;

  @Before
  public void setUp() {
    sortingService = new Quick3wayServiceImpl();
  }

  @Override
  protected SortingService getSortingService() {
    return sortingService;
  }
}
