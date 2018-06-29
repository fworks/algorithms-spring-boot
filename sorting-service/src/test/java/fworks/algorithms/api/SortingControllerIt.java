package fworks.algorithms.api;

import fworks.algorithms.api.SortingController;
import fworks.algorithms.api.model.SortingRequest;
import fworks.algorithms.api.model.SortingResponse;
import fworks.algorithms.sorting.quicksort.Quick3wayService;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Integration testing for the SortingController.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SortingControllerIt {

  @LocalServerPort
  protected int port;

  private static final String URL_BASE = "http://localhost:%s/";

  @Autowired
  protected TestRestTemplate template;

  /**
   * Setup the test rest template.<br>
   * Set the root url.
   */
  @Before
  public void setUpForIntegration() {
    String url = String.format(URL_BASE, port);
    log.info("Base url for test: {}", url);
    template.setUriTemplateHandler(new RootUriTemplateHandler(url));
  }

  /**
   * Execute the sorting all endpoint.
   */
  @Test
  public void sortingAllTest() {
    // request
    long[] array = {10, 2, 5, 86, 99, 1, 6, 0};
    long[] sorted = {0, 1, 2, 5, 6, 10, 86, 99};
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();

    String url = SortingController.API + SortingController.SORTING_ALL;
    ResponseEntity<SortingRequest> response =
        template.postForEntity(url, sortingRequest, SortingRequest.class);

    SortingRequest sortingAll = response.getBody();
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length, 0);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
      Assert.assertArrayEquals(sorted, sortingResponse.getSortedArray());
      log.info(sortingResponse);
    }
  }

  /**
   * Execute the sorting all endpoint.
   */
  @Test
  public void sortingAllSortedTest() {
    // request
    long[] array = {0, 10, 20, 30, 45, 68, 89, 112, 896};
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();

    String url = SortingController.API + SortingController.SORTING_ALL;
    ResponseEntity<SortingRequest> response =
        template.postForEntity(url, sortingRequest, SortingRequest.class);

    SortingRequest sortingAll = response.getBody();
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length, 0);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
      Assert.assertArrayEquals(array, sortingResponse.getSortedArray());
      log.info(sortingResponse);
      if (!Quick3wayService.QUICK3WAY.equals(sortingResponse.getAlgorithm())) {
        Assert.assertEquals(0, sortingResponse.getNumberOfExchanges());
      }
    }
  }

  /**
   * Execute the sorting all file endpoint.
   * 
   * @throws IOException
   */
  @Test
  public void sortingAllFileTest() throws IOException {
    // request
    Resource fileTest = new ClassPathResource("arrayLongUnsorted200.txt");

    MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>(2);
    bodyMap.add("uploadfile", fileTest);
    bodyMap.add("key", 10L);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

    String url = SortingController.API + SortingController.SORTING_ALL_FILE;
    ResponseEntity<SortingRequest> response =
        template.postForEntity(url, requestEntity, SortingRequest.class);

    SortingRequest sortingAll = response.getBody();
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length, 0);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
      Assert.assertTrue(sortingResponse.getNumberOfExchanges() > 0);
    }
  }
}
