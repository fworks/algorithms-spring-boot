package fworks.algorithms.searching.bruteforce;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import fworks.algorithms.searching.SearchService;
import org.junit.Before;

public class BruteForceSearchServiceTest extends AbstractSearchServiceTest {

  private BruteForceSearchService bruteForce;

  @Before
  public void setUp() {
    bruteForce = new BruteForceSearchServiceImpl();
  }

  @Override
  protected SearchService getSearchService() {
    return bruteForce;
  }
}
