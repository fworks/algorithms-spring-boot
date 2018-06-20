package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import fworks.algorithms.searching.SearchService;
import org.junit.Before;

public class BinarySearchRecursiveServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchRecursiveService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchRecursiveServiceImpl();
  }

  @Override
  protected SearchService getSearchService() {
    return binarySearch;
  }
  
}
