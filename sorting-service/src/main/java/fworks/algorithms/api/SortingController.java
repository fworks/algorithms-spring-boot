package fworks.algorithms.api;

import fworks.algorithms.sorting.SortingRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  /**
   * Constructor default.<br/>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   * @param bruteForceSortingService brute force service
   * @param binarySorting binary service
   * @param binarySortingRecursiveService binary recursive service
   */
  @Autowired
  public SortingController() {}

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param sortingRequest request
   * @return list of sorting results
   */
  @PostMapping("/allComparative")
  public ResponseEntity<?> sortingAll(@RequestBody SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @param key to be found
   * @return list of sorting results
   */
  @PostMapping("/allComparativeFile")
  public ResponseEntity<?> sortingAllFile(@RequestPart(required = true) MultipartFile uploadfile,
      @RequestParam long key) {
    log.info("Sorting all! {}", key);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }



  /**
   * Execute a sorting using bruteForce.
   * 
   * @param sortingRequest request
   * @return index position
   */
  @PostMapping("/bruteForce")
  public ResponseEntity<?> sortingBruteForce(@RequestBody SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  /**
   * Execute a sorting using binary sorting.
   * 
   * @param sortingRequest request
   * @return index position
   */
  @PostMapping("/binaryLoop")
  public ResponseEntity<?> sortingBinary(@RequestBody SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }

  /**
   * Execute a sorting using binary sorting.
   * 
   * @param sortingRequest request
   * @return index position
   */
  @PostMapping("/binaryRecursive")
  public ResponseEntity<?> sortingBinaryRecursive(@RequestBody SortingRequest sortingRequest) {
    log.info("Sorting all! {}", sortingRequest);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  }
}
