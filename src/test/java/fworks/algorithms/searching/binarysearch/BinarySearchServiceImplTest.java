package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import fworks.algorithms.searching.binarysearch.BinarySearchService;
import fworks.algorithms.searching.binarysearch.BinarySearchServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchServiceImpl();
  }

  @Test
  public void commonTest() {
    super.executeCommonTests(binarySearch);
  }
}
