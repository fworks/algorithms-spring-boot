package fworks.algorithms.sorting.sort.bubblesort;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the BubblesortService.
 * 
 * @author flaviolcastro
 *
 */
public class BubblesortServiceTest extends AbstractSortingServiceTest {

  private BubblesortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new BubblesortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }

}
