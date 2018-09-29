package fworks.algorithms.sorting.model.sortingrequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SortingRequestServiceTest {

  private SortingRequestService sortingRequestService;
  private SortingRequestRepository repository;

  /**
   * Setup the test with the mock services.
   */
  @BeforeEach
  public void setUp() {
    // mock services
    repository = Mockito.mock(SortingRequestRepository.class);
    sortingRequestService = new SortingRequestService(repository);
  }

  @Test
  public void saveTest() {
    long[] array = {10, 2, 56};
    SortingRequest request = SortingRequest.builder().array(array).build();

    String id = "123";
    SortingRequest mockedRequest = SortingRequest.builder().id(id).array(array).build();


    Mockito.when(repository.save(request)).thenReturn(mockedRequest);
    SortingRequest saved = sortingRequestService.save(request);
    Assertions.assertArrayEquals(request.getArray(), saved.getArray());
    Assertions.assertEquals(saved.getId(), id);
  }
}
