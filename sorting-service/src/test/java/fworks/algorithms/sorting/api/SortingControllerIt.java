package fworks.algorithms.sorting.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
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
public class SortingControllerIt {

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
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingRequest sortingRequest = new SortingRequest(10, array);

    String url = SortingController.API + SortingController.SORTING_ALL;
    ResponseEntity<SortingResponse[]> response =
        template.postForEntity(url, sortingRequest, SortingResponse[].class);

    SortingResponse[] sortingAll = response.getBody();
    Assert.assertEquals(0, sortingAll.length, 0);
    for (SortingResponse sortingResponse : sortingAll) {
      Assert.assertEquals(1, sortingResponse.getIndex(), 0);
    }
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // request
    Resource fileTest = new ClassPathResource("arraylong0to50_000.txt");

    MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>(2);
    bodyMap.add("uploadfile", fileTest);
    bodyMap.add("key", 10L);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

    String url = SortingController.API + SortingController.SORTING_ALL_FILE;
    ResponseEntity<SortingResponse[]> response =
        template.postForEntity(url, requestEntity, SortingResponse[].class);

    SortingResponse[] sortingAll = response.getBody();
    Assert.assertEquals(0, sortingAll.length, 0);
    for (SortingResponse sortingResponse : sortingAll) {
      Assert.assertEquals(10, sortingResponse.getIndex(), 0);
    }
  }
}
