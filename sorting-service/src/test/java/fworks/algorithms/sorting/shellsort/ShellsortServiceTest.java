package fworks.algorithms.sorting.shellsort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class ShellsortServiceTest extends AbstractSortingServiceTest {

  private ShellsortService sortingService;

  @Before
  public void setUp() {
    sortingService = new ShellsortServiceImpl();
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
