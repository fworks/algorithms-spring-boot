package fworks.algorithms.sorting.sort.quicksort;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the QuicksortService.
 * 
 * @author flaviolcastro
 *
 */
public class QuicksortServiceTest extends AbstractSortingServiceTest {

  private QuicksortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new QuicksortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
