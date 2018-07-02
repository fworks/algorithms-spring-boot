package fworks.algorithms.sorting.sort.bubblesort;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.bubblesort.BubblesortService;
import fworks.algorithms.sorting.sort.bubblesort.BubblesortServiceImpl;
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

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }

}
