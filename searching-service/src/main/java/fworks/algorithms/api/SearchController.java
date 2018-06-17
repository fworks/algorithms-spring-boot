package fworks.algorithms.api;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.binarysearch.BinarySearchService;
import fworks.algorithms.searching.bruteforce.BruteForceSearchService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
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
 * Rest API for the search algorithms.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = SearchController.API)
public class SearchController {

  protected static final String API = "/search";

  private BruteForceSearchService bruteForceSearchService;
  private BinarySearchService binarySearch;
  private BinarySearchRecursiveService binarySearchRecursiveService;

  /**
   * Constructor default.<br/>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   * @param bruteForceSearchService brute force service
   * @param binarySearch binary service
   * @param binarySearchRecursiveService binary recursive service
   */
  @Autowired
  public SearchController(BruteForceSearchService bruteForceSearchService,
      BinarySearchService binarySearch, BinarySearchRecursiveService binarySearchRecursiveService) {
    this.bruteForceSearchService = bruteForceSearchService;
    this.binarySearch = binarySearch;
    this.binarySearchRecursiveService = binarySearchRecursiveService;
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param searchRequest request
   * @return list of search results
   */
  @PostMapping("/allComparative")
  public ResponseEntity<?> searchAll(@RequestBody SearchRequest searchRequest) {
    try {
      // TODO: return a comparative between all algorithms
      SearchResponse[] bag = new SearchResponse[3];
      bag[0] = bruteForceSearchService.search(searchRequest);
      bag[1] = binarySearch.search(searchRequest);
      bag[2] = binarySearchRecursiveService.search(searchRequest);
      return ResponseEntity.ok(bag);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @param key to be found
   * @return list of search results
   */
  @PostMapping("/allComparativeFile")
  public ResponseEntity<?> searchAllFile(@RequestPart(required = true) MultipartFile uploadfile,
      @RequestParam long key) {
    try {
      // get file
      Path uploadedTempFile = Files.createTempFile("upload", ".txt");
      uploadfile.transferTo(uploadedTempFile.toFile());
      // read the file
      List<String> readAllLines = Files.readAllLines(uploadedTempFile);
      long[] array = readAllLines.stream().mapToLong(t -> Long.parseLong(t)).toArray();
      SearchRequest searchRequest = SearchRequest.builder().key(key).array(array).build();
      return this.searchAll(searchRequest);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }



  /**
   * Execute a search using bruteForce.
   * 
   * @param searchRequest request
   * @return index position
   */
  @PostMapping("/bruteForce")
  public ResponseEntity<?> searchBruteForce(@RequestBody SearchRequest searchRequest) {
    try {
      SearchResponse result = bruteForceSearchService.search(searchRequest);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  /**
   * Execute a search using binary search.
   * 
   * @param searchRequest request
   * @return index position
   */
  @PostMapping("/binaryLoop")
  public ResponseEntity<?> searchBinary(@RequestBody SearchRequest searchRequest) {
    try {
      SearchResponse result = binarySearch.search(searchRequest);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  /**
   * Execute a search using binary search.
   * 
   * @param searchRequest request
   * @return index position
   */
  @PostMapping("/binaryRecursive")
  public ResponseEntity<?> searchBinaryRecursive(@RequestBody SearchRequest searchRequest) {
    try {
      SearchResponse result = binarySearchRecursiveService.search(searchRequest);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
