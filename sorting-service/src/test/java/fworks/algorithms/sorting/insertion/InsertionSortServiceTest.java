package fworks.algorithms.sorting.insertion;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class InsertionSortServiceTest extends AbstractSortingServiceTest {

  private InsertionSortService sortingService;

  @Before
  public void setUp() {
    sortingService = new InsertionSortServiceImpl();
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
