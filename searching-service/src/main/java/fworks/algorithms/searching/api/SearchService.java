package fworks.algorithms.searching.api;

import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;
import fworks.algorithms.searching.model.searchrequest.SearchRequestService;
import fworks.algorithms.searching.model.searchrequest.SearchResponse;
import fworks.algorithms.searching.search.binarysearch.BinarySearchRecursiveService;
import fworks.algorithms.searching.search.binarysearch.BinarySearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Rest API for the search algorithms.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@Service
public class SearchService {

  protected static final int NUMBER_OF_ALGORITHMS = 3;

  private final SearchRequestService searchRequestService;
  private final BruteForceSearchService bruteForceSearchService;
  private final BinarySearchService binarySearch;
  private final BinarySearchRecursiveService binarySearchRecursiveService;

  /**
   * Constructor default.<br>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   * @param searchRequestService search request service
   * @param bruteForceSearchService brute force service
   * @param binarySearch binary service
   * @param binarySearchRecursiveService binary recursive service
   */
  @Autowired
  public SearchService(SearchRequestService searchRequestService,
      BruteForceSearchService bruteForceSearchService, BinarySearchService binarySearch,
      BinarySearchRecursiveService binarySearchRecursiveService) {
    this.searchRequestService = searchRequestService;
    this.bruteForceSearchService = bruteForceSearchService;
    this.binarySearch = binarySearch;
    this.binarySearchRecursiveService = binarySearchRecursiveService;
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param searchInput input for the search
   * @return list of search results
   */
  public SearchRequest searchAll(@Validated SearchInput searchInput) {
    log.info("Searching all! Request {}", searchInput);
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(searchInput.getArray()) //
        .key(searchInput.getKey()) //
        .build();
    // save the request
    searchRequest = this.searchRequestService.save(searchRequest);
    // execute the search for all algorithms
    SearchResponse[] responses = new SearchResponse[NUMBER_OF_ALGORITHMS];
    responses[0] = bruteForceSearchService.search(searchRequest);
    responses[1] = binarySearch.search(searchRequest);
    responses[2] = binarySearchRecursiveService.search(searchRequest);
    searchRequest.setResponses(responses);
    // update with the responses
    return this.searchRequestService.save(searchRequest);
  }

  /**
   * Execute a search using bruteForce.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  public SearchRequest searchBruteForce(@Validated SearchInput searchInput) {
    log.info("Searching brute force! Request {}", searchInput);
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(searchInput.getArray()) //
        .key(searchInput.getKey()) //
        .build();
    // save the request
    searchRequest = this.searchRequestService.save(searchRequest);
    // execute the search
    SearchResponse searchResponse = bruteForceSearchService.search(searchRequest);
    searchRequest.setResponses(new SearchResponse[] {searchResponse});
    // update with the responses
    return this.searchRequestService.save(searchRequest);
  }

  /**
   * Execute a search using binary search internal loop implementation.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  public SearchRequest searchBinary(@Validated SearchInput searchInput) {
    log.info("Searching binary loop! Request {}", searchInput);
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(searchInput.getArray()) //
        .key(searchInput.getKey()) //
        .build();
    // save the request
    searchRequest = this.searchRequestService.save(searchRequest);
    // execute the search
    SearchResponse searchResponse = binarySearch.search(searchRequest);
    searchRequest.setResponses(new SearchResponse[] {searchResponse});
    // update with the responses
    return this.searchRequestService.save(searchRequest);
  }

  /**
   * Execute a search using binary search recursive implementation.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  public SearchRequest searchBinaryRecursive(@Validated SearchInput searchInput) {
    log.info("Searching binary recursive! Request {}", searchInput);
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(searchInput.getArray()) //
        .key(searchInput.getKey()) //
        .build();
    // save the request
    searchRequest = this.searchRequestService.save(searchRequest);
    // execute the search
    SearchResponse searchResponse = binarySearchRecursiveService.search(searchRequest);
    searchRequest.setResponses(new SearchResponse[] {searchResponse});
    // update with the responses
    return this.searchRequestService.save(searchRequest);
  }
}
