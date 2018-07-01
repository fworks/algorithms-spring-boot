package fworks.algorithms.searching.search.bruteforce;

import fworks.algorithms.searching.search.AbstractSearchServiceTest;
import fworks.algorithms.searching.search.AlgorithmSearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchService;
import fworks.algorithms.searching.search.bruteforce.BruteForceSearchServiceImpl;
import org.junit.Before;

public class BruteForceSearchServiceTest extends AbstractSearchServiceTest {

  private BruteForceSearchService bruteForce;

  @Before
  public void setUp() {
    bruteForce = new BruteForceSearchServiceImpl();
  }

  @Override
  protected AlgorithmSearchService getSearchService() {
    return bruteForce;
  }
}
