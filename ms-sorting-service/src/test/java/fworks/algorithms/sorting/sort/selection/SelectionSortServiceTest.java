package fworks.algorithms.sorting.sort.selection;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the SelectionSortService.
 * 
 * @author flaviolcastro
 *
 */
public class SelectionSortServiceTest extends AbstractSortingServiceTest {

  private SelectionSortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new SelectionSortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
