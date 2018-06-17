package fworks.algorithms.api;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.binarysearch.BinarySearchService;
import fworks.algorithms.searching.bruteforce.BruteForceSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class SearchControllerTest {

  private SearchController searchController;

  private BruteForceSearchService bruteForceSearchService;
  private BinarySearchService binarySearch;
  private BinarySearchRecursiveService binarySearchRecursiveService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    bruteForceSearchService = Mockito.mock(BruteForceSearchService.class);
    binarySearch = Mockito.mock(BinarySearchService.class);
    binarySearchRecursiveService = Mockito.mock(BinarySearchRecursiveService.class);
    searchController =
        new SearchController(bruteForceSearchService, binarySearch, binarySearchRecursiveService);
  }

  @Test
  public void searchAllTest() {
    long[] array = {0,10};
    SearchRequest searchRequest = new SearchRequest(10, array);
    ResponseEntity<?> searchAll = searchController.searchAll(searchRequest);
    Assert.assertEquals(3, ((SearchResponse[])searchAll.getBody()).length, 0);
  }

}
