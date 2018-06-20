package fworks.algorithms.searching.binarysearch;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import fworks.algorithms.searching.SearchService;
import org.junit.Before;

public class BinarySearchServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchServiceImpl();
  }

  @Override
  protected SearchService getSearchService() {
    return binarySearch;
  }
}
