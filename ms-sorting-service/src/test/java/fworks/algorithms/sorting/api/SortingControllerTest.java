package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.model.SortingInput;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

/**
 * Unit testing the SortingController.
 * 
 * @author flaviolcastro
 *
 */
public class SortingControllerTest {

  private SortingController sortingController;

  private SortingService sortingService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    sortingService = Mockito.mock(SortingService.class);
    sortingController = new SortingController(sortingService);
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingInput sortingInput = SortingInput.builder().array(array).build();
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();

    // mock services
    Mockito.when(sortingService.sortingAll(sortingInput)).thenReturn(sortingRequest);

    SortingRequest sortingAll = sortingController.sortingAll(sortingInput);
    Assert.assertEquals(sortingRequest, sortingAll);
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // get the file
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arrayLongUnsorted200.txt").getInputStream());
    long[] array = sortingController.readArrayFromFile(mockMultipartFile);
    // mock services
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();
    SortingInput sortingInput = SortingInput.builder().array(array).build();
    Mockito.when(sortingService.sortingAll(sortingInput)).thenReturn(sortingRequest);

    SortingRequest sortingAll = sortingController.sortingAllFile(mockMultipartFile);
    Assert.assertEquals(sortingRequest, sortingAll);
  }

  @Test(expected = RuntimeException.class)
  public void sortingAllFileWrongFileTest() {
    // negative test
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "asd".getBytes());
    sortingController.sortingAllFile(mockMultipartFile);
  }

}
