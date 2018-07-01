package fworks.algorithms.sorting.sort.quicksort;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.quicksort.Quick3wayService;
import fworks.algorithms.sorting.sort.quicksort.Quick3wayServiceImpl;
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
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
