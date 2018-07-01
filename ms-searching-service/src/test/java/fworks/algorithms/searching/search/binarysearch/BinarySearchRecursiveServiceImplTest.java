package fworks.algorithms.searching.search.binarysearch;

import fworks.algorithms.searching.search.AbstractSearchServiceTest;
import fworks.algorithms.searching.search.AlgorithmSearchService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchRecursiveServiceImpl;
import org.junit.Before;

public class BinarySearchRecursiveServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchRecursiveService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchRecursiveServiceImpl();
  }

  @Override
  protected AlgorithmSearchService getSearchService() {
    return binarySearch;
  }
  
}
