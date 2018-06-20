package fworks.algorithms.sorting.quicksort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class Quick3wayServiceTest extends AbstractSortingServiceTest {

  private Quick3wayService sortingService;

  @Before
  public void setUp() {
    sortingService = new Quick3wayServiceImpl();
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
