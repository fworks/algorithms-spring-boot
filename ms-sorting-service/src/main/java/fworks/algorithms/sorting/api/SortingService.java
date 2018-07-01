package fworks.algorithms.sorting.api;

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
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Rest API for the sorting algorithms.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class SortingService {

  protected static final int NUMBER_OF_ALGORITHMS = 7;

  private final SortingRequestService sortingRequestService;
  private final InsertionSortService insertionSortService;
  private final SelectionSortService selectionSortService;
  private final ShellsortService shellsortService;
  private final MergesortService mergesortService;
  private final QuicksortService quicksortService;
  private final Quick3wayService quick3wayService;
  private final BubblesortService bubblesortService;

  /**
   * Constructor default.<br>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   */
  @Autowired
  public SortingService(SortingRequestService sortingRequestService,
      InsertionSortService insertionSortService, SelectionSortService selectionSortService,
      ShellsortService shellsortService, MergesortService mergesortService,
      QuicksortService quicksortService, Quick3wayService quick3wayService,
      BubblesortService bubblesortService) {
    this.sortingRequestService = sortingRequestService;
    this.insertionSortService = insertionSortService;
    this.selectionSortService = selectionSortService;
    this.shellsortService = shellsortService;
    this.mergesortService = mergesortService;
    this.quicksortService = quicksortService;
    this.quick3wayService = quick3wayService;
    this.bubblesortService = bubblesortService;
  }

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param sortingRequest request
   * @return list of sorting results
   */
  public SortingRequest sortingAll(@RequestBody @Validated SortingInput sortingInput) {
    log.info("Sorting all! {}", sortingInput);
    SortingRequest sortingRequest = SortingRequest.builder().array(sortingInput.getArray()).build();
    // save the request on the db
    sortingRequest = sortingRequestService.save(sortingRequest);
    SortingResponse[] responses = new SortingResponse[NUMBER_OF_ALGORITHMS];
    // insertion sort
    responses[0] = insertionSortService.sort(sortingRequest);
    // selection sort
    responses[1] = selectionSortService.sort(sortingRequest);
    // shellsort
    responses[2] = shellsortService.sort(sortingRequest);
    // mergesort
    responses[3] = mergesortService.sort(sortingRequest);
    // quicksort
    responses[4] = quicksortService.sort(sortingRequest);
    // quick3way sort
    responses[5] = quick3wayService.sort(sortingRequest);
    // bubble sort
    responses[6] = bubblesortService.sort(sortingRequest);
    // update the request with the responses
    sortingRequest.setResponses(responses);
    return sortingRequestService.save(sortingRequest);
  }
}
