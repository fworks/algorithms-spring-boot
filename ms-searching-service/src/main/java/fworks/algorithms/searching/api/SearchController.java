package fworks.algorithms.searching.api;

import fworks.algorithms.searching.model.SearchInput;
import fworks.algorithms.searching.model.searchrequest.SearchRequest;
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

  private final SearchService searchService;

  /**
   * Constructor default.<br>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   * @param searchService search service
   */
  @Autowired
  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param searchInput input for the search
   * @return list of search results
   */
  @PostMapping(SEARCH_ALL)
  public SearchRequest searchAll(@RequestBody @Validated SearchInput searchInput) {
    log.info("Searching all! Request {}", searchInput);
    return searchService.searchAll(searchInput);
  }

  /**
   * Execute a search algorithm comparative.
   * 
   * @param uploadfile with the array input
   * @param key to be found
   * @return list of search results
   */
  @PostMapping(SEARCH_ALL_FILE)
  public SearchRequest searchAllFile(
      @RequestPart(required = true) @NotNull MultipartFile uploadfile,
      @RequestParam @NotNull long key) {
    long[] array = readArrayFromFile(uploadfile);
    SearchInput searchInput = SearchInput.builder().key(key).array(array).build();
    return this.searchAll(searchInput);
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

  /**
   * Execute a search using bruteForce.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  @PostMapping(SEARCH_BRUTE_FORCE)
  public SearchRequest searchBruteForce(@RequestBody @Validated SearchInput searchInput) {
    log.info("Searching brute force! Request {}", searchInput);
    return this.searchService.searchBruteForce(searchInput);
  }

  /**
   * Execute a search using binary search internal loop implementation.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  @PostMapping(SEARCH_BINARY_LOOP)
  public SearchRequest searchBinary(@RequestBody @Validated SearchInput searchInput) {
    log.info("Searching binary loop! Request {}", searchInput);
    return this.searchService.searchBinary(searchInput);
  }

  /**
   * Execute a search using binary search recursive implementation.
   * 
   * @param searchInput input for the search
   * @return search response object
   */
  @PostMapping(SEARCH_BINARY_RECURSIVE)
  public SearchRequest searchBinaryRecursive(@RequestBody @Validated SearchInput searchInput) {
    log.info("Searching binary recursive! Request {}", searchInput);
    return this.searchService.searchBinaryRecursive(searchInput);
  }
}
