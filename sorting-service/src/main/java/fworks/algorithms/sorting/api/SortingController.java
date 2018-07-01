package fworks.algorithms.sorting.api;

import fworks.algorithms.sorting.model.SortingInput;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;
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

  private final SortingService sortingService;

  /**
   * Constructor default.<br>
   * Autowiring the constructor instead of the properties for easing the service mocking on the
   * tests.
   * 
   */
  @Autowired
  public SortingController(SortingService sortingService) {
    this.sortingService = sortingService;
  }

  /**
   * Execute a sorting algorithm comparative.
   * 
   * @param sortingInput request
   * @return list of sorting results
   */
  @PostMapping(SORTING_ALL)
  public SortingRequest sortingAll(@RequestBody @Validated SortingInput sortingInput) {
    log.info("Sorting all! {}", sortingInput);
    return sortingService.sortingAll(sortingInput);
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
    return this.sortingAll(SortingInput.builder().array(array).build());
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
