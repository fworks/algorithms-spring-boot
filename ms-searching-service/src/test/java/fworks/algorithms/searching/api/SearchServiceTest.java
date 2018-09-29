package fworks.algorithms.searching.api;

import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;
import fworks.algorithms.searching.model.searchrequest.SearchRequestService;
import fworks.algorithms.searching.model.searchrequest.SearchResponse;
import fworks.algorithms.searching.search.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for SearchService.
 * 
 * @author flaviolcastro
 *
 */
@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

  private SearchService searchService;

  private SearchRequestService searchRequestService;
  private BruteForceSearchService bruteForceSearchService;
  private BinarySearchService binarySearch;
  private BinarySearchRecursiveService binarySearchRecursiveService;

  /**
   * Setup the test with the mock services.
   */
  @BeforeEach
  public void setUp() {
    // mock services
    searchRequestService = Mockito.mock(SearchRequestService.class);
    bruteForceSearchService = Mockito.mock(BruteForceSearchService.class);
    binarySearch = Mockito.mock(BinarySearchService.class);
    binarySearchRecursiveService = Mockito.mock(BinarySearchRecursiveService.class);
    searchService = new SearchService(searchRequestService, bruteForceSearchService,
        binarySearch, binarySearchRecursiveService);
  }

  @Test
  public void searchAllTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequest = SearchRequest.builder().array(array).key(10).build();

    // mock services
    SearchResponse searchResponseMocked = new SearchResponse();
    Mockito.when(searchRequestService.save(Mockito.any())).thenReturn(searchRequest);
    Mockito.when(bruteForceSearchService.search(searchRequest)).thenReturn(searchResponseMocked);
    Mockito.when(binarySearch.search(searchRequest)).thenReturn(searchResponseMocked);
    Mockito.when(binarySearchRecursiveService.search(searchRequest))
        .thenReturn(searchResponseMocked);

    SearchResponse[] searchAll = searchService.searchAll(searchInput).getResponses();
    Assertions.assertEquals(SearchService.NUMBER_OF_ALGORITHMS, searchAll.length);
    for (SearchResponse searchResponse : searchAll) {
      Assertions.assertEquals(searchResponseMocked, searchResponse);
    }
  }

  @Test
  public void searchBinaryTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequest = SearchRequest.builder().array(array).key(10).build();

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(searchRequestService.save(Mockito.any())).thenReturn(searchRequest);
    Mockito.when(binarySearch.search(searchRequest)).thenReturn(searchResponseMocked);

    SearchResponse searchResponse = searchService.searchBinary(searchInput).getResponses()[0];
    Assertions.assertEquals(10, searchResponse.getIndex());
    Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
  }

  @Test
  public void searchBinaryRecursiveTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequest = SearchRequest.builder().array(array).key(10).build();

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(searchRequestService.save(Mockito.any())).thenReturn(searchRequest);
    Mockito.when(binarySearchRecursiveService.search(searchRequest))
        .thenReturn(searchResponseMocked);

    SearchResponse searchResponse =
        searchService.searchBinaryRecursive(searchInput).getResponses()[0];
    Assertions.assertEquals(10, searchResponse.getIndex());
    Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
  }

  @Test
  public void searchBruteForceTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequest = SearchRequest.builder().array(array).key(10).build();

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(searchRequestService.save(Mockito.any())).thenReturn(searchRequest);
    Mockito.when(bruteForceSearchService.search(searchRequest)).thenReturn(searchResponseMocked);

    SearchResponse searchResponse =
        searchService.searchBruteForce(searchInput).getResponses()[0];
    Assertions.assertEquals(10, searchResponse.getIndex());
    Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
  }

}
