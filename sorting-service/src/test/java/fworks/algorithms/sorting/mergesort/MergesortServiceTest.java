package fworks.algorithms.sorting.mergesort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import fworks.algorithms.sorting.SortingService;
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
  protected SortingService getSortingService() {
    return sortingService;
  }
}
