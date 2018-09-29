package fworks.algorithms.searching.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;
import fworks.algorithms.searching.model.searchrequest.SearchResponse;
import lombok.extern.log4j.Log4j2;

/**
 * Integration test for SearchController.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerIt {

  @LocalServerPort
  protected int port;

  private static final String URL_BASE = "http://localhost:%s/";

  @Autowired
  protected TestRestTemplate template;

  /**
   * Setup the test rest template.<br>
   * Set the root url.
   */
  @BeforeEach
  public void setUpForIntegration() {
    String url = String.format(URL_BASE, port);
    log.info("Base url for test: {}", url);
    template.setUriTemplateHandler(new RootUriTemplateHandler(url));
  }

  /**
   * Test search all endpoint.
   */
  @Test
  public void searchAllTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();

    String url = SearchController.API + SearchController.SEARCH_ALL;
    ResponseEntity<SearchRequest> response =
        template.postForEntity(url, searchInput, SearchRequest.class);

    SearchResponse[] searchAll = response.getBody().getResponses();
    Assertions.assertEquals(SearchService.NUMBER_OF_ALGORITHMS, searchAll.length);
    for (SearchResponse searchResponse : searchAll) {
      Assertions.assertEquals(1, searchResponse.getIndex());
    }
  }

  /**
   * Test search all file endpoint.
   */
  @Test
  public void searchAllFileTest() {
    // request
    Resource fileTest = new ClassPathResource("arraylong0to50_000.txt");

    MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>(2);
    bodyMap.add("uploadfile", fileTest);
    bodyMap.add("key", 10L);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

    String url = SearchController.API + SearchController.SEARCH_ALL_FILE;
    ResponseEntity<SearchRequest> response =
        template.postForEntity(url, requestEntity, SearchRequest.class);

    SearchResponse[] searchAll = response.getBody().getResponses();
    Assertions.assertEquals(SearchService.NUMBER_OF_ALGORITHMS, searchAll.length);
    for (SearchResponse searchResponse : searchAll) {
      Assertions.assertEquals(10, searchResponse.getIndex());
    }
  }

  /**
   * Test binary search loop endpoint.
   */
  @Test
  public void searchBinaryTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();

    ResponseEntity<SearchRequest> response =
        template.postForEntity(SearchController.API + SearchController.SEARCH_BINARY_LOOP,
            searchInput, SearchRequest.class);
    //
    SearchResponse searchResponse = response.getBody().getResponses()[0];
    Assertions.assertEquals(1, searchResponse.getIndex());
    Assertions.assertEquals(2, searchResponse.getNumberOfKeysAnalized());
  }

  /**
   * Test binary search recursive endpoint.
   */
  @Test
  public void searchBinaryRecursiveTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();

    String url = SearchController.API + SearchController.SEARCH_BINARY_RECURSIVE;
    ResponseEntity<SearchRequest> response =
        template.postForEntity(url, searchInput, SearchRequest.class);
    //
    SearchResponse searchResponse = response.getBody().getResponses()[0];
    Assertions.assertEquals(1, searchResponse.getIndex());
    Assertions.assertEquals(2, searchResponse.getNumberOfKeysAnalized());
  }

  /**
   * Test brute force endpoint.
   */
  @Test
  public void searchBruteForceTest() {
    // request
    long[] array = {0, 10};
    SearchInput searchInput = SearchInput.builder().array(array).key(10).build();

    String url = SearchController.API + SearchController.SEARCH_BRUTE_FORCE;
    ResponseEntity<SearchRequest> response =
        template.postForEntity(url, searchInput, SearchRequest.class);
    //
    SearchResponse searchResponse = response.getBody().getResponses()[0];
    Assertions.assertEquals(1, searchResponse.getIndex());
    Assertions.assertEquals(2, searchResponse.getNumberOfKeysAnalized());
  }

}
