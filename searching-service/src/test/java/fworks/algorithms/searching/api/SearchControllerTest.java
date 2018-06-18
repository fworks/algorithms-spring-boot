package fworks.algorithms.searching.api;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.binarysearch.BinarySearchService;
import fworks.algorithms.searching.bruteforce.BruteForceSearchService;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

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
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    // mock services
    SearchResponse searchResponseMocked = new SearchResponse();
    Mockito.when(bruteForceSearchService.search(searchRequest)).thenReturn(searchResponseMocked);
    Mockito.when(binarySearch.search(searchRequest)).thenReturn(searchResponseMocked);
    Mockito.when(binarySearchRecursiveService.search(searchRequest))
        .thenReturn(searchResponseMocked);

    SearchResponse[] searchAll = searchController.searchAll(searchRequest);
    Assert.assertEquals(3, searchAll.length, 0);
    for (SearchResponse searchResponse : searchAll) {
      Assert.assertEquals(searchResponseMocked, searchResponse);
    }
  }

  @Test
  public void searchAllFileTest() throws IOException {
    // mock services
    SearchResponse searchResponseMocked = new SearchResponse();
    Mockito.when(bruteForceSearchService.search(Mockito.any())).thenReturn(searchResponseMocked);
    Mockito.when(binarySearch.search(Mockito.any())).thenReturn(searchResponseMocked);
    Mockito.when(binarySearchRecursiveService.search(Mockito.any()))
        .thenReturn(searchResponseMocked);

    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arraylong0to50_000.txt").getInputStream());

    SearchResponse[] searchAll = searchController.searchAllFile(mockMultipartFile, 10);
    Assert.assertEquals(3, searchAll.length, 0);
    for (SearchResponse searchResponse : searchAll) {
      Assert.assertEquals(searchResponseMocked, searchResponse);
    }
  }

  @Test(expected = RuntimeException.class)
  public void searchAllFileWrongFileTest() {
    // negative test
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "asd".getBytes());
    searchController.searchAllFile(mockMultipartFile, 10);
  }


  @Test
  public void searchBinaryTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(binarySearch.search(searchRequest)).thenReturn(searchResponseMocked);

    SearchResponse searchResponse = searchController.searchBinary(searchRequest);
    Assert.assertEquals(10, searchResponse.getIndex(), 0);
    Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBinaryRecursiveTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(binarySearchRecursiveService.search(searchRequest))
        .thenReturn(searchResponseMocked);

    SearchResponse searchResponse = searchController.searchBinaryRecursive(searchRequest);
    Assert.assertEquals(10, searchResponse.getIndex(), 0);
    Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBruteForceTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    // mock services
    SearchResponse searchResponseMocked = SearchResponse.builder() //
        .index(10) //
        .numberOfKeysAnalized(1) //
        .build();

    Mockito.when(bruteForceSearchService.search(searchRequest)).thenReturn(searchResponseMocked);

    SearchResponse searchResponse = searchController.searchBruteForce(searchRequest);
    Assert.assertEquals(10, searchResponse.getIndex(), 0);
    Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

}
