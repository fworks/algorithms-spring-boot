package fworks.algorithms.api;

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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Rest API for the sorting algorithms.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = SortingController.API)
public class SortingController {

  protected static final String API = "/";
  protected static final String SORTING_ALL = "/allComparative";
  protected static final String SORTING_ALL_FILE = "/allComparativeFile";

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
  public SortingController(SortingRequestService sortingRequestService,
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
  @PostMapping(SORTING_ALL)
  public SortingRequest sortingAll(@RequestBody @Validated SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
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

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @return list of sorting results
   */
  @PostMapping(SORTING_ALL_FILE)
  public SortingRequest sortingAllFile(
      @RequestPart(required = true) @NotNull MultipartFile uploadfile) {
    log.info("Sorting all! {}", uploadfile.getName());
    long[] array = readArrayFromFile(uploadfile);
    return this.sortingAll(SortingRequest.builder().array(array).build());
  }

  /**
   * Read an array from an uploaded file.
   * @param uploadedfile file
   * @return array of values
   */
  protected long[] readArrayFromFile(MultipartFile uploadedfile) {
    long[] array;
    try {
      log.info("Sorting all! Request: File:{}", uploadedfile.getName());
      // get file
      Path uploadedTempFile = Files.createTempFile("upload", ".txt");
      uploadedfile.transferTo(uploadedTempFile.toFile());
      // read the file
      List<String> readAllLines = Files.readAllLines(uploadedTempFile);
      array = readAllLines.stream().mapToLong(t -> Long.parseLong(t)).toArray();
    } catch (Exception e) {
      log.error("Error reading array from file!", e);
      throw new RuntimeException("Error reading the file!", e);
    }
    return array;
  }
}
