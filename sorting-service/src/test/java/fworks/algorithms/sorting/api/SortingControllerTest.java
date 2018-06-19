package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
import fworks.algorithms.sorting.insertion.InsertionSortService;
import fworks.algorithms.sorting.selection.SelectionSortService;
import fworks.algorithms.sorting.shellsort.ShellsortService;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;

public class SortingControllerTest {

  private SortingController sortingController;

  private InsertionSortService insertionSortService;
  private SelectionSortService selectionSortService;
  private ShellsortService shellsortService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    insertionSortService = Mockito.mock(InsertionSortService.class);
    selectionSortService = Mockito.mock(SelectionSortService.class);
    shellsortService = Mockito.mock(ShellsortService.class);
    sortingController = new SortingController(insertionSortService, selectionSortService, shellsortService);
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingRequest sortingRequest = new SortingRequest(array);

    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    Mockito.when(insertionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(selectionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(shellsortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);

    SortingResponse[] sortingAll = sortingController.sortingAll(sortingRequest);
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.length, 0);
    for (SortingResponse sortingResponse : sortingAll) {
      Assert.assertEquals(sortingResponseMocked, sortingResponse);
    }
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    Mockito.when(insertionSortService.sort(Mockito.any())).thenReturn(sortingResponseMocked);
    Mockito.when(selectionSortService.sort(Mockito.any())).thenReturn(sortingResponseMocked);
    Mockito.when(shellsortService.sort(Mockito.any())).thenReturn(sortingResponseMocked);

    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arrayLongUnsorted200.txt").getInputStream());

    SortingResponse[] sortingAll = sortingController.sortingAllFile(mockMultipartFile);
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.length, 0);
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
