package fworks.algorithms.sorting.sort.shellsort;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the ShellsortService.
 * 
 * @author flaviolcastro
 *
 */
public class ShellsortServiceTest extends AbstractSortingServiceTest {

  private ShellsortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new ShellsortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
