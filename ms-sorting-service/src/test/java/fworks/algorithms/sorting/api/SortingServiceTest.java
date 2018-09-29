package fworks.algorithms.sorting.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import fworks.algorithms.sorting.model.SortingInput;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequestService;
import fworks.algorithms.sorting.model.sortingrequest.SortingResponse;
import fworks.algorithms.sorting.sort.bubblesort.BubblesortService;
import fworks.algorithms.sorting.sort.insertion.InsertionSortService;
import fworks.algorithms.sorting.sort.mergesort.MergesortService;
import fworks.algorithms.sorting.sort.quicksort.Quick3wayService;
import fworks.algorithms.sorting.sort.quicksort.QuicksortService;
import fworks.algorithms.sorting.sort.selection.SelectionSortService;
import fworks.algorithms.sorting.sort.shellsort.ShellsortService;

/**
 * Unit testing the SortingService.
 * 
 * @author flaviolcastro
 *
 */
@ExtendWith(MockitoExtension.class)
public class SortingServiceTest {

  private SortingService sortingService;

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
  @BeforeEach
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
    sortingService = new SortingService(sortingRequestService, insertionSortService,
        selectionSortService, shellsortService, mergesortService, quicksortService,
        quick3wayService, bubblesortService);
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingInput sortingInput = SortingInput.builder().array(array).build();
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

    SortingRequest sortingAll = sortingService.sortingAll(sortingInput);
    Assertions.assertEquals(SortingService.NUMBER_OF_ALGORITHMS, sortingAll.getResponses().length);
    for (SortingResponse sortingResponse : sortingAll.getResponses()) {
      Assertions.assertEquals(sortingResponseMocked, sortingResponse);
    }
  }
}
