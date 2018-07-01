package fworks.algorithms.sorting.sort.mergesort;

import fworks.algorithms.sorting.sort.AbstractSortingServiceTest;
import fworks.algorithms.sorting.sort.AlgorithmSortService;
import fworks.algorithms.sorting.sort.mergesort.MergesortService;
import fworks.algorithms.sorting.sort.mergesort.MergesortServiceImpl;
import org.junit.Before;

/**
 * Testing the MergesortService.
 * 
 * @author flaviolcastro
 *
 */
public class MergesortServiceTest extends AbstractSortingServiceTest {

  private MergesortService sortingService;

  @Before
  public void setUp() {
    sortingService = new MergesortServiceImpl();
  }

  @Override
  protected AlgorithmSortService getSortingService() {
    return sortingService;
  }
}
