package fworks.algorithms.api;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.binary.BinarySearch;
import fworks.algorithms.searching.bruteforce.BruteForceSearchService;
import java.time.Duration;
import java.time.Instant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = SearchController.API)
public class SearchController {

  protected static final String API = "/search";

  private BruteForceSearchService bruteForceSearchService;
  private BinarySearch binarySearch;

  @Autowired
  public SearchController(BruteForceSearchService bruteForceSearchService,
      BinarySearch binarySearch) {
    this.bruteForceSearchService = bruteForceSearchService;
    this.binarySearch = binarySearch;
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param searchRequest request
   * @return index position
   */
  @PostMapping("/allComparative")
  public ResponseEntity<?> searchAll(@RequestBody SearchRequest searchRequest) {
    try {
      // TODO: return a comparative between all algorithms
      Instant now = Instant.now();
      int result = bruteForceSearchService.search(searchRequest.getKey(), searchRequest.getArray());
      String timing = Duration.between(now, Instant.now()).toString();
      return ResponseEntity.ok(result + "|" + timing);
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
      int result = bruteForceSearchService.search(searchRequest.getKey(), searchRequest.getArray());
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
      int result = binarySearch.searchLoop(searchRequest.getKey(), searchRequest.getArray());
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
      int result = binarySearch.searchRecursive(searchRequest.getKey(), searchRequest.getArray());
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
