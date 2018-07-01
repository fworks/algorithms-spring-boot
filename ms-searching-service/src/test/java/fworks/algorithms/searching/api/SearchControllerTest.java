package fworks.algorithms.searching.api;

import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

/**
 * Unit test for SearchController.
 * 
 * @author flaviolcastro
 *
 */
public class SearchControllerTest {

  private SearchController searchController;

  private SearchService searchService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    searchService = Mockito.mock(SearchService.class);
    searchController = new SearchController(searchService);
  }

  @Test
  public void searchAllTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequestMocked = SearchRequest.builder().array(array).key(10).build();

    // mock services
    Mockito.when(searchService.searchAll(searchInput)).thenReturn(searchRequestMocked);

    SearchRequest searchAll = searchController.searchAll(searchInput);
    Assert.assertEquals(searchRequestMocked, searchAll);
  }

  @Test
  public void searchAllFileTest() throws IOException {

    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arraylong0to50_000.txt").getInputStream());
    
    long[] array = searchController.readArrayFromFile(mockMultipartFile);
    
    SearchRequest searchRequestMocked = SearchRequest.builder().array(array).key(10).build();
    
    // mock services
    Mockito.when(searchService.searchAll(Mockito.any())).thenReturn(searchRequestMocked);

    SearchRequest searchAll = searchController.searchAllFile(mockMultipartFile, 10);
    Assert.assertEquals(searchRequestMocked, searchAll);
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
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequestMocked = SearchRequest.builder().array(array).key(10).build();

    // mock services
    Mockito.when(searchService.searchBinary(searchInput)).thenReturn(searchRequestMocked);

    SearchRequest searchBinary = searchController.searchBinary(searchInput);
    Assert.assertEquals(searchRequestMocked, searchBinary);
    // Assert.assertEquals(10, searchResponse.getIndex(), 0);
    // Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBinaryRecursiveTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequestMocked = SearchRequest.builder().array(array).key(10).build();

    // mock services
    Mockito.when(searchService.searchBinaryRecursive(searchInput)).thenReturn(searchRequestMocked);

    SearchRequest searchBinaryRecursive = searchController.searchBinaryRecursive(searchInput);
    Assert.assertEquals(searchRequestMocked, searchBinaryRecursive);
    // Assert.assertEquals(10, searchResponse.getIndex(), 0);
    // Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBruteForceTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();
    SearchRequest searchRequestMocked = SearchRequest.builder().array(array).key(10).build();

    // mock services
    Mockito.when(searchService.searchBruteForce(searchInput)).thenReturn(searchRequestMocked);

    SearchRequest searchBruteForce = searchController.searchBruteForce(searchInput);
    Assert.assertEquals(searchRequestMocked, searchBruteForce);
    // Assert.assertEquals(10, searchResponse.getIndex(), 0);
    // Assert.assertEquals(1, searchResponse.getNumberOfKeysAnalized(), 0);
  }

}
