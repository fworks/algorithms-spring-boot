package fworks.algorithms.sorting.sort.mergesort;

import org.junit.jupiter.api.BeforeEach;
import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;

/**
 * Testing the MergesortService.
 * 
 * @author flaviolcastro
 *
 */
public class MergesortServiceTest extends AbstractSortingServiceTest {

  private MergesortService sortingService;

  @BeforeEach
  public void setUp() {
    sortingService = new MergesortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
