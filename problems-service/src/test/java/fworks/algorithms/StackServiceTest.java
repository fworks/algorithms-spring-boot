package fworks.algorithms;

import fworks.algorithms.problems.basics.StackService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackServiceTest {

  StackService stackService;
  
  @Before
  public void setUp() {
    stackService = new StackService();
  }
  
  @Test
  public void test() {
    double value = stackService.evaluateDijkstra("(1+2)");
    Assert.assertEquals(3.0, value, 0);
    
    double value2 = stackService.evaluateDijkstra("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) ");
    Assert.assertEquals(101, value2, 0);
  }
}
