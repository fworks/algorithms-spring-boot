package fworks.algorithms.problems.josephus;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class JosephusProblemServiceTest {

  private JosephusProblemService josephusProblemService;

  @Before
  public void setUp() {
    josephusProblemService = new JosephusProblemServiceImpl();
  }

  @Test
  public void test() {
    this.testJosephus(2, 7, 6);
    this.testJosephus(2, 20, 8);
    this.testJosephus(4, 70, 5);
    this.testJosephus(3, 1500, 904);
    this.testJosephus(1, 10, 9);
    this.testJosephus(0, 10, 9);
  }
  
  private void testJosephus(int m, int n, int last) {
    int lastPosition = josephusProblemService.solve(m, n);
    log.info("Josephus {} {} - Expected: {} Result: {}", m, n, last, lastPosition);
    Assert.assertEquals(last, lastPosition, 0);
  }
}
