package fworks.algorithms.sorting.sort.quicksort;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the Quick3wayService.
 * 
 * @author flaviolcastro
 *
 */
public class Quick3wayServiceTest extends AbstractSortingServiceTest {

  private Quick3wayService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new Quick3wayServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
