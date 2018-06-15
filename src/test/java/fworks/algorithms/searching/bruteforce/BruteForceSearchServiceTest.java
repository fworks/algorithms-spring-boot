package fworks.algorithms.searching.bruteforce;

import fworks.algorithms.searching.AbstractSearchServiceTest;
import org.junit.Before;
import org.junit.Test;

public class BruteForceSearchServiceTest extends AbstractSearchServiceTest {

  private BruteForceSearchService bruteForce;

  @Before
  public void setUp() {
    bruteForce = new BruteForceSearchServiceImpl();
  }

  @Test
  public void commonTest() {
    super.executeCommonTests(bruteForce);
  }
}
