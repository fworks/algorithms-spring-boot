package fworks.algorithms.sorting.model.sortingrequest;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sorting Request Service class.<br>
 * Responsible for access the repository.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class SortingRequestService {

  private final SortingRequestRepository repository;

  @Autowired
  public SortingRequestService(SortingRequestRepository sortingRequestRepository) {
    this.repository = sortingRequestRepository;
  }

  /**
   * Save a Sorting Request.
   * 
   * @param request to be saved
   * @return saved sorting request
   */
  public SortingRequest save(@NotNull final SortingRequest request) {
    return this.repository.save(request);
  }
}
