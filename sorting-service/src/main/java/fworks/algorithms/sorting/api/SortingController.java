package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.SortingRequest;
import fworks.algorithms.sorting.SortingResponse;
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
  
  /**
   * Constructor default.<br/>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   */
  @Autowired
  public SortingController() {}

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param sortingRequest request
   * @return list of sorting results
   */
  @PostMapping(SORTING_ALL)
  public SortingResponse[] sortingAll(@RequestBody @Validated SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    return new SortingResponse[] {};
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
    return new SortingResponse[] {};
  }



}
