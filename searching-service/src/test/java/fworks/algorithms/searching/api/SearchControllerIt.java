package fworks.algorithms.searching.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@Log4j2
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = "spring.profiles.include=test")
public class SearchControllerIt {

  @LocalServerPort
  protected int port;

  private static final String URL_BASE = "http://localhost:%s/";

  @Autowired
  protected TestRestTemplate template;

  @Autowired
  protected ObjectMapper mapper;

  @Autowired
  protected MappingJackson2HttpMessageConverter httpMessageConverter;

  /**
   * Setup the test rest template.<br/>
   * Set the root url.
   */
  @Before
  public void setUpForIntegration() {
    String url = String.format(URL_BASE, port);
    log.info("Base url for test: {}", url);
    template.setUriTemplateHandler(new RootUriTemplateHandler(url));
  }

  @Test
  public void searchAllTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    String url = SearchController.API + SearchController.SEARCH_ALL;
    ResponseEntity<SearchResponse[]> response =
        template.postForEntity(url, searchRequest, SearchResponse[].class);

    SearchResponse[] searchAll = response.getBody();
    Assert.assertEquals(3, searchAll.length, 0);
    for (SearchResponse searchResponse : searchAll) {
      Assert.assertEquals(1, searchResponse.getIndex(), 0);
    }
  }

  @Test
  public void searchAllFileTest() throws IOException {
    // request
    Resource fileTest = new ClassPathResource("arraylong0to50_000.txt");

    MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>(2);
    bodyMap.add("uploadfile", fileTest);
    bodyMap.add("key", 10L);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

    String url = SearchController.API + SearchController.SEARCH_ALL_FILE;
    ResponseEntity<SearchResponse[]> response =
        template.postForEntity(url, requestEntity, SearchResponse[].class);

    SearchResponse[] searchAll = response.getBody();
    Assert.assertEquals(3, searchAll.length, 0);
    for (SearchResponse searchResponse : searchAll) {
      Assert.assertEquals(10, searchResponse.getIndex(), 0);
    }
  }

  @Test
  public void searchBinaryTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    ResponseEntity<SearchResponse> response =
        template.postForEntity(SearchController.API + SearchController.SEARCH_BINARY_LOOP,
            searchRequest, SearchResponse.class);
    //
    SearchResponse searchResponse = response.getBody();
    Assert.assertEquals(1, searchResponse.getIndex(), 0);
    Assert.assertEquals(2, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBinaryRecursiveTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    String url = SearchController.API + SearchController.SEARCH_BINARY_RECURSIVE;
    ResponseEntity<SearchResponse> response =
        template.postForEntity(url, searchRequest, SearchResponse.class);
    //
    SearchResponse searchResponse = response.getBody();
    Assert.assertEquals(1, searchResponse.getIndex(), 0);
    Assert.assertEquals(2, searchResponse.getNumberOfKeysAnalized(), 0);
  }

  @Test
  public void searchBruteForceTest() {
    // request
    long[] array = {0, 10};
    SearchRequest searchRequest = new SearchRequest(10, array);

    String url = SearchController.API + SearchController.SEARCH_BRUTE_FORCE;
    ResponseEntity<SearchResponse> response =
        template.postForEntity(url, searchRequest, SearchResponse.class);
    //
    SearchResponse searchResponse = response.getBody();
    Assert.assertEquals(1, searchResponse.getIndex(), 0);
    Assert.assertEquals(2, searchResponse.getNumberOfKeysAnalized(), 0);
  }

}
