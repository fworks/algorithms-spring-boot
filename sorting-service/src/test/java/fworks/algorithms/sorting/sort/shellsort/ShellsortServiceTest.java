package fworks.algorithms.sorting.sort.shellsort;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.shellsort.ShellsortService;
import fworks.algorithms.sorting.sort.shellsort.ShellsortServiceImpl;
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
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
