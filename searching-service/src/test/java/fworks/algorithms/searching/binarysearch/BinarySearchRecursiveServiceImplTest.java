package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchRecursiveServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchRecursiveService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchRecursiveServiceImpl();
  }
  
  @Test
  public void commonTest() {
    super.executeCommonTests(binarySearch);
  }
}
