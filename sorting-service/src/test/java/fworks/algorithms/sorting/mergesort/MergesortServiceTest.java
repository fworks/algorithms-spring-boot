package fworks.algorithms.sorting.mergesort;

import fworks.algorithms.sorting.AbstractSortingServiceTest;
import org.junit.Before;
import org.junit.Test;

public class MergesortServiceTest extends AbstractSortingServiceTest {

  private MergesortService sortingService;

  @Before
  public void setUp() {
    sortingService = new MergesortServiceImpl();
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
