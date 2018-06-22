package fworks.algorithms.searching.api;

import fworks.algorithms.searching.SearchRequest;
import fworks.algorithms.searching.SearchResponse;
import fworks.algorithms.searching.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.binarysearch.BinarySearchService;
import fworks.algorithms.searching.bruteforce.BruteForceSearchService;
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

  protected static final String API = "/";
  protected static final String SEARCH_ALL = "/allComparative";
  protected static final String SEARCH_ALL_FILE = "/allComparativeFile";
  protected static final String SEARCH_BRUTE_FORCE = "/bruteForce";
  protected static final String SEARCH_BINARY_LOOP = "/binaryLoop";
  protected static final String SEARCH_BINARY_RECURSIVE = "/binaryRecursive";
  
  protected static final int NUMBER_OF_ALGORITHMS = 3;

  private final BruteForceSearchService bruteForceSearchService;
  private final BinarySearchService binarySearch;
  private final BinarySearchRecursiveService binarySearchRecursiveService;

  /**
   * Constructor default.<br>
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
  @PostMapping(SEARCH_ALL)
  public SearchResponse[] searchAll(@RequestBody @Validated SearchRequest searchRequest) {
    log.info("Searching all! Request {}", searchRequest);
    // return a comparative between all algorithms
    SearchResponse[] responses = new SearchResponse[NUMBER_OF_ALGORITHMS];
    responses[0] = bruteForceSearchService.search(searchRequest);
    responses[1] = binarySearch.search(searchRequest);
    responses[2] = binarySearchRecursiveService.search(searchRequest);
    return responses;
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @param key to be found
   * @return list of search results
   */
  @PostMapping(SEARCH_ALL_FILE)
  public SearchResponse[] searchAllFile(
      @RequestPart(required = true) @NotNull MultipartFile uploadfile,
      @RequestParam @NotNull long key) {

    long[] array;
    try {
      log.info("Searching all! Request: File:{} Key:{}", uploadfile.getName(), key);
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
    SearchRequest searchRequest = SearchRequest.builder().key(key).array(array).build();
    return this.searchAll(searchRequest);
  }

  /**
   * Execute a search using bruteForce.
   * 
   * @param searchRequest request
   * @return search response object
   */
  @PostMapping(SEARCH_BRUTE_FORCE)
  public SearchResponse searchBruteForce(@RequestBody @Validated SearchRequest searchRequest) {
    log.info("Searching brute force! Request {}", searchRequest);
    return bruteForceSearchService.search(searchRequest);
  }

  /**
   * Execute a search using binary search internal loop implementation.
   * 
   * @param searchRequest request
   * @return search response object
   */
  @PostMapping(SEARCH_BINARY_LOOP)
  public SearchResponse searchBinary(@RequestBody @Validated SearchRequest searchRequest) {
    log.info("Searching binary loop! Request {}", searchRequest);
    return binarySearch.search(searchRequest);
  }

  /**
   * Execute a search using binary search recursive implementation.
   * 
   * @param searchRequest request
   * @return search response object
   */
  @PostMapping(SEARCH_BINARY_RECURSIVE)
  public SearchResponse searchBinaryRecursive(@RequestBody @Validated SearchRequest searchRequest) {
    log.info("Searching binary recursive! Request {}", searchRequest);
    return binarySearchRecursiveService.search(searchRequest);
  }
}
