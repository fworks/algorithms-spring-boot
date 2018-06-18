package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

public class SortingControllerTest {

  private SortingController sortingController;

  // private BruteForceSortingService bruteForceSortingService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    // bruteForceSortingService = Mockito.mock(BruteForceSortingService.class);
    sortingController = new SortingController();
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingRequest sortingRequest = new SortingRequest(10, array);

    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    //Mockito.when(bruteForceSortingService.sorting(sortingRequest)).thenReturn(sortingResponseMocked);

    SortingResponse[] sortingAll = sortingController.sortingAll(sortingRequest);
    Assert.assertEquals(0, sortingAll.length, 0);
    for (SortingResponse sortingResponse : sortingAll) {
      Assert.assertEquals(sortingResponseMocked, sortingResponse);
    }
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    //Mockito.when(bruteForceSortingService.sorting(Mockito.any())).thenReturn(sortingResponseMocked);

    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arraylong0to50_000.txt").getInputStream());

    SortingResponse[] sortingAll = sortingController.sortingAllFile(mockMultipartFile);
    Assert.assertEquals(0, sortingAll.length, 0);
    for (SortingResponse sortingResponse : sortingAll) {
      Assert.assertEquals(sortingResponseMocked, sortingResponse);
    }
  }

  @Test(expected = RuntimeException.class)
  public void sortingAllFileWrongFileTest() {
    // negative test
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "asd".getBytes());
    sortingController.sortingAllFile(mockMultipartFile);
  }

}
