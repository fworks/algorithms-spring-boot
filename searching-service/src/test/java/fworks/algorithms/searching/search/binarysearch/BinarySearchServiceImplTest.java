package fworks.algorithms.searching.search.binarysearch;

import fworks.algorithms.searching.search.AbstractSearchServiceTest;
import fworks.algorithms.searching.search.AlgorithmSearchService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchServiceImpl;
import org.junit.Before;

public class BinarySearchServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchService binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchServiceImpl();
  }

  @Override
  protected AlgorithmSearchService getSearchService() {
    return binarySearch;
  }
}
