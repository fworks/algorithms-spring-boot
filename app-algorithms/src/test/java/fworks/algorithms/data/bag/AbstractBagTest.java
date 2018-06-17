package fworks.algorithms.data.bag;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

/**
 * Commmon tests for bags.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractBagTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 50;

  protected void validateString(Bag<String> bag, String word) {
    // validate the initial values
    log.info("Bag: {}", bag);
    Assert.assertEquals(0, bag.size(), 0);
    Assert.assertTrue(bag.isEmpty());

    String[] test = word.trim().split("");
    //
    boolean logInsideLoop = test.length > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      bag.add(item1);
      // validate
      Assert.assertEquals(i + 1, bag.size(), 0);
      Assert.assertFalse(bag.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Bag: {}", bag);
      }
    }
    log.info("-> Bag: {}", bag);
    //Assert.assertTrue(test.length == bag.toArray().length);
  }

  protected void validateInteger(Bag<Integer> bag, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;
    // validate the initial values
    log.info("Bag: {}", bag);
    Assert.assertEquals(0, bag.size(), 0);
    Assert.assertTrue(bag.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      bag.add(item1);
      // validate
      Assert.assertEquals(i + 1, bag.size(), 0);
      Assert.assertFalse(bag.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Bag: {}", bag);
      }
    }
    log.info("-> Bag: {}", bag);
  }
}
