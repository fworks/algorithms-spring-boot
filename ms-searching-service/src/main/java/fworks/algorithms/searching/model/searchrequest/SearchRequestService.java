package fworks.algorithms.searching.model.searchrequest;

import java.util.Arrays;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Search Request Service class.<br>
 * 
 * @author flaviolcastro
 *
 */
@Service
public class SearchRequestService {

  private final SearchRequestRepository searchRequestRepository;
  private final SearchResponseRepository searchResponseRepository;

  /**
   * Autowired constructor.
   * 
   * @param searchRequestRepository request repository
   * @param searchResponseRepository response repository
   */
  @Autowired
  public SearchRequestService(SearchRequestRepository searchRequestRepository,
      SearchResponseRepository searchResponseRepository) {
    this.searchRequestRepository = searchRequestRepository;
    this.searchResponseRepository = searchResponseRepository;
  }

  /**
   * Save a Search Request.
   * 
   * @param request to be saved
   * @return saved sorting request
   */
  public SearchRequest save(@NotNull final SearchRequest request) {
    if (request.getResponses() != null) {
      this.searchResponseRepository.saveAll(Arrays.asList(request.getResponses()));
    }
    return this.searchRequestRepository.save(request);
  }
}
