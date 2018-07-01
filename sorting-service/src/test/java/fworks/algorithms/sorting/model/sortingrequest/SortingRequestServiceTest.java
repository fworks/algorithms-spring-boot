package fworks.algorithms.sorting.model.sortingrequest;

import fworks.algorithms.sorting.model.sortingrequest.SortingRequest;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequestRepository;
import fworks.algorithms.sorting.model.sortingrequest.SortingRequestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SortingRequestServiceTest {

  private SortingRequestService sortingRequestService;
  private SortingRequestRepository repository;

  /**
   * Setup the test with the mock services.
   */
  @Before
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
    Assert.assertArrayEquals(request.getArray(), saved.getArray());
    Assert.assertEquals(saved.getId(), id);
  }
}
