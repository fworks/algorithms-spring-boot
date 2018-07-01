package fworks.algorithms.sorting.sort.selection;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.selection.SelectionSortService;
import fworks.algorithms.sorting.sort.selection.SelectionSortServiceImpl;
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
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
