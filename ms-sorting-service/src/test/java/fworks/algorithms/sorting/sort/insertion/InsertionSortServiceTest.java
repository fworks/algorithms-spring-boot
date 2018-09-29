package fworks.algorithms.sorting.sort.insertion;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the InsertionSortService.
 * 
 * @author flaviolcastro
 *
 */
public class InsertionSortServiceTest extends AbstractSortingServiceTest {

  private InsertionSortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new InsertionSortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }

}
