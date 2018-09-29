package fworks.algorithms.searching.search.binarysearch;

import fworks.algorithms.searching.search.AbstractSearchServiceTest;
import fworks.algorithms.searching.search.AlgorithmSearchService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;

public class BinarySearchServiceImplTest extends AbstractSearchServiceTest {

  private BinarySearchService binarySearch;

  @BeforeEach
  public void setUp() {
    binarySearch = new BinarySearchServiceImpl();
  }

  @Override
  protected AlgorithmSearchService getSearchService() {
    return binarySearch;
  }
}
