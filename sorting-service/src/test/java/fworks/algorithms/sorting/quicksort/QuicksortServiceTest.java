package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class QuicksortServiceTest extends AbstractSortingServiceTest {

  private QuicksortService sortingService;

  @Before
  public void setUp() {
    sortingService = new QuicksortServiceImpl();
  }

  @Test
  public void commonTest() {
    super.executeLongPrimitiveTest(sortingService);
  }

  @Test
  public void common2Test() {
    super.executeStringTest(sortingService);
  }
}
