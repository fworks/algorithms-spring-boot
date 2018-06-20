package fworks.algorithms.sorting.selection;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class SelectionSortServiceTest extends AbstractSortingServiceTest {

  private SelectionSortService sortingService;

  @Before
  public void setUp() {
    sortingService = new SelectionSortServiceImpl();
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
