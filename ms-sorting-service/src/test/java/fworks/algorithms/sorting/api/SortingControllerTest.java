package fworks.algorithms.sorting.api;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import fworks.algorithms.sorting.model.SortingInput;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;

/**
 * Unit testing the SortingController.
 * 
 * @author flaviolcastro
 *
 */
@ExtendWith(MockitoExtension.class)
public class SortingControllerTest {

  private SortingController sortingController;

  private SortingService sortingService;

  /**
   * Setup the test with the mock services.
   */
  @BeforeEach
  public void setUp() {
    // mock services
    sortingService = Mockito.mock(SortingService.class);
    sortingController = new SortingController(sortingService);
  }

  @Test
  public void sortingAllTest() {
    // request
    long[] array = {0, 10};
    SortingInput sortingInput = SortingInput.builder().array(array).build();
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();

    // mock services
    Mockito.when(sortingService.sortingAll(sortingInput)).thenReturn(sortingRequest);

    SortingRequest sortingAll = sortingController.sortingAll(sortingInput);
    Assertions.assertEquals(sortingRequest, sortingAll);
  }

  @Test
  public void sortingAllFileTest() throws IOException {
    // get the file
    MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt",
        new ClassPathResource("arrayLongUnsorted200.txt").getInputStream());
    long[] array = sortingController.readArrayFromFile(mockMultipartFile);
    // mock services
    SortingRequest sortingRequest = SortingRequest.builder().array(array).build();
    SortingInput sortingInput = SortingInput.builder().array(array).build();
    Mockito.when(sortingService.sortingAll(sortingInput)).thenReturn(sortingRequest);

    SortingRequest sortingAll = sortingController.sortingAllFile(mockMultipartFile);
    Assertions.assertEquals(sortingRequest, sortingAll);
  }

  @Test
  public void sortingAllFileWrongFileTest() {
    // negative test
    Assertions.assertThrows(RuntimeException.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("test.txt", "asd".getBytes());
        sortingController.sortingAllFile(mockMultipartFile);
      }
    });
  }

}
