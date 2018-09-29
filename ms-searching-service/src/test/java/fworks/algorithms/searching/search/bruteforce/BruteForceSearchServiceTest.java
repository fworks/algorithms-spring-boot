package fworks.algorithms.searching.search.bruteforce;

import fworks.algorithms.searching.search.AbstractSearchServiceTest;
import fworks.algorithms.searching.search.AlgorithmSearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;

public class BruteForceSearchServiceTest extends AbstractSearchServiceTest {

  private BruteForceSearchService bruteForce;

  @BeforeEach
  public void setUp() {
    bruteForce = new BruteForceSearchServiceImpl();
  }

  @Override
  protected AlgorithmSearchService getSearchService() {
    return bruteForce;
  }
}
