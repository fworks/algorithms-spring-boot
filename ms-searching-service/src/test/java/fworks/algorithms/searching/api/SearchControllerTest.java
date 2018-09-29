package fworks.algorithms.searching.api;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;

/**
 * Unit test for SearchController.
 * 
 * @author flaviolcastro
 *
 */
@ExtendWith(MockitoExtension.class)
public class SearchControllerTest {

  private SearchController searchController;

  private SearchService searchService;

  /**
   * Setup the test with the mock services.
   */
  @BeforeEach
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
    Assertions.assertEquals(searchRequestMocked, searchAll);
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
    Assertions.assertEquals(searchRequestMocked, searchAll);
  }

  @Test
  public void searchAllFileWrongFileTest() {
    // negative test
    Assertions.assertThrows(RuntimeException.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "asd".getBytes());
        searchController.searchAllFile(mockMultipartFile, 10);
      }
    });
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
    Assertions.assertEquals(searchRequestMocked, searchBinary);
    // Assertions.assertEquals(10, searchResponse.getIndex());
    // Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
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
    Assertions.assertEquals(searchRequestMocked, searchBinaryRecursive);
    // Assertions.assertEquals(10, searchResponse.getIndex());
    // Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
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
    Assertions.assertEquals(searchRequestMocked, searchBruteForce);
    // Assertions.assertEquals(10, searchResponse.getIndex());
    // Assertions.assertEquals(1, searchResponse.getNumberOfKeysAnalized());
  }

}
