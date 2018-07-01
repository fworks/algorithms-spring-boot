package fworks.algorithms.sorting.sort.insertion;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.insertion.InsertionSortService;
import fworks.algorithms.sorting.sort.insertion.InsertionSortServiceImpl;
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
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }

}
