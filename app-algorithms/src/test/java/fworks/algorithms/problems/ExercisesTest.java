package fworks.algorithms.problems;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;

@Log4j2
public class ExercisesTest {

  @Test
  public void exercise1_1_1() {

    int exp1 = (0 + 15) / 2;
    log.info(exp1);
    Assert.assertEquals(7, exp1, 0);

    double exp2 = 2.0e-6 * 100_000_000.1;
    log.info(exp2);
    Assert.assertEquals(200.0000002, exp2, 0);

    boolean exp3 = true && false || true && true;
    log.info(exp3);
    Assert.assertTrue(exp3);
  }

  @Test
  public void exercise1_1_2() {

    double exp1 = (1 + 2.236) / 2;
    log.info(exp1);
    Assert.assertEquals(1.618, exp1, 0);

    double exp2 = 1 + 2 + 3 + 4.0;
    log.info(exp2);
    Assert.assertEquals(10.0, exp2, 0);

    boolean exp3 = 4.1 >= 4;
    log.info(exp3);
    Assert.assertTrue(exp3);

    String exp4 = 1 + 2 + "3";
    log.info(exp4);
    Assert.assertEquals("33", exp4);
  }

  @Test
  public void exercise1_1_7() {

    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001) {
      t = (9.0 / t + t) / 2.0;
    }
    log.info(String.format("%.5f\n", t));

    int sum = 0;
    for (int i = 1; i < 1000; i++) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }
    log.info(sum);

    sum = 0;
    for (int i = 1; i < 1000; i *= 2) {
      for (int j = 0; j < 1000; j++) {
        sum++;
      }
    }
    log.info(sum);
  }

  @Test
  public void exercise1_2_4() {
    String string1 = "hello";
    String string2 = string1;
    string1 = "world";
    log.info(string1);
    log.info(string2);
  }
}
