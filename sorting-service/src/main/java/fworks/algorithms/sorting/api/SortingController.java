package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
import fworks.algorithms.sorting.insertion.InsertionSortService;
import fworks.algorithms.sorting.mergesort.MergesortService;
import fworks.algorithms.sorting.quicksort.Quick3wayService;
import fworks.algorithms.sorting.quicksort.QuicksortService;
import fworks.algorithms.sorting.selection.SelectionSortService;
import fworks.algorithms.sorting.shellsort.ShellsortService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
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

  protected static final String API = "/sorting";
  protected static final String SORTING_ALL = "/allComparative";
  protected static final String SORTING_ALL_FILE = "/allComparativeFile";

  protected static final int NUMBER_OF_ALGORITHMS = 6;

  private final InsertionSortService insertionSortService;
  private final SelectionSortService selectionSortService;
  private final ShellsortService shellsortService;
  private final MergesortService mergesortService;
  private final QuicksortService quicksortService;
  private final Quick3wayService quick3wayService;


  /**
   * Constructor default.<br/>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   */
  @Autowired
  public SortingController(InsertionSortService insertionSortService,
      SelectionSortService selectionSortService, ShellsortService shellsortService,
      MergesortService mergesortService, QuicksortService quicksortService,
      Quick3wayService quick3wayService) {
    this.insertionSortService = insertionSortService;
    this.selectionSortService = selectionSortService;
    this.shellsortService = shellsortService;
    this.mergesortService = mergesortService;
    this.quicksortService = quicksortService;
    this.quick3wayService = quick3wayService;
  }

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param sortingRequest request
   * @return list of sorting results
   */
  @PostMapping(SORTING_ALL)
  public SortingResponse[] sortingAll(@RequestBody @Validated SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    SortingResponse[] responses = new SortingResponse[NUMBER_OF_ALGORITHMS];
    long[] copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[0] = insertionSortService.sort(new SortingRequest(copyOf));
    copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[1] = selectionSortService.sort(new SortingRequest(copyOf));
    copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[2] = shellsortService.sort(new SortingRequest(copyOf));
    copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[3] = mergesortService.sort(new SortingRequest(copyOf));
    copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[4] = quicksortService.sort(new SortingRequest(copyOf));
    copyOf = Arrays.copyOf(sortingRequest.getArray(), sortingRequest.getArray().length);
    responses[5] = quick3wayService.sort(new SortingRequest(copyOf));
    return responses;
  }

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @return list of sorting results
   */
  @PostMapping(SORTING_ALL_FILE)
  public SortingResponse[] sortingAllFile(
      @RequestPart(required = true) @NotNull MultipartFile uploadfile) {
    log.info("Sorting all! {}", uploadfile.getName());
    long[] array;
    try {
      log.info("Sorting all! Request: File:{}", uploadfile.getName());
      // get file
      Path uploadedTempFile = Files.createTempFile("upload", ".txt");
      uploadfile.transferTo(uploadedTempFile.toFile());
      // read the file
      List<String> readAllLines = Files.readAllLines(uploadedTempFile);
      array = readAllLines.stream().mapToLong(t -> Long.parseLong(t)).toArray();
    } catch (Exception e) {
      log.error("Error reading array from file!", e);
      throw new RuntimeException("Error reading the file!", e);
    }
    SortingRequest sortingRequest = new SortingRequest(array);
    return this.sortingAll(sortingRequest);
  }



}
