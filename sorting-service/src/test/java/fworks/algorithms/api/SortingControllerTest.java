package fworks.algorithms.api;

import fworks.algorithms.api.SortingController;
import fworks.algorithms.api.model.SortingRequest;
import fworks.algorithms.api.model.SortingRequestService;
import fworks.algorithms.api.model.SortingResponse;
import fworks.algorithms.sorting.bubblesort.BubblesortService;
import fworks.algorithms.sorting.insertion.InsertionSortService;
import fworks.algorithms.sorting.mergesort.MergesortService;
import fworks.algorithms.sorting.quicksort.Quick3wayService;
import fworks.algorithms.sorting.quicksort.QuicksortService;
import fworks.algorithms.sorting.selection.SelectionSortService;
import fworks.algorithms.sorting.shellsort.ShellsortService;
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

  private SortingRequestService sortingRequestService;
  private InsertionSortService insertionSortService;
  private SelectionSortService selectionSortService;
  private ShellsortService shellsortService;
  private MergesortService mergesortService;
  private QuicksortService quicksortService;
  private Quick3wayService quick3wayService;
  private BubblesortService bubblesortService;

  /**
   * Setup the test with the mock services.
   */
  @Before
  public void setUp() {
    // mock services
    insertionSortService = Mockito.mock(InsertionSortService.class);
    selectionSortService = Mockito.mock(SelectionSortService.class);
    shellsortService = Mockito.mock(ShellsortService.class);
    mergesortService = Mockito.mock(MergesortService.class);
    quicksortService = Mockito.mock(QuicksortService.class);
    quick3wayService = Mockito.mock(Quick3wayService.class);
    bubblesortService = Mockito.mock(BubblesortService.class);
    sortingRequestService = Mockito.mock(SortingRequestService.class);
    sortingController = new SortingController(sortingRequestService, insertionSortService,
        selectionSortService, shellsortService, mergesortService, quicksortService,
        quick3wayService, bubblesortService);
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();

    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    Mockito.when(sortingRequestService.save(sortingRequest)).thenReturn(sortingRequest);
    Mockito.when(insertionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(selectionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(shellsortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(mergesortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(quicksortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(quick3wayService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(bubblesortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);

    SortingRequest sortingAll = sortingController.sortingAll(sortingRequest);
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length, 0);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
      Assert.assertEquals(sortingResponseMocked, sortingResponse);
    }
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // get the file
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arrayLongUnsorted200.txt").getInputStream());
    long[] array = sortingController.readArrayFromFile(mockMultipartFile);
    // mock services
    SortingResponse sortingResponseMocked = new SortingResponse();
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();
    Mockito.when(sortingRequestService.save(sortingRequest)).thenReturn(sortingRequest);
    Mockito.when(insertionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(selectionSortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(shellsortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(mergesortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(quicksortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(quick3wayService.sort(sortingRequest)).thenReturn(sortingResponseMocked);
    Mockito.when(bubblesortService.sort(sortingRequest)).thenReturn(sortingResponseMocked);

    SortingRequest sortingAll = sortingController.sortingAllFile(mockMultipartFile);
    Assert.assertEquals(SortingController.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length, 0);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
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
