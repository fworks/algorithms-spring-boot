package fworks.algorithms.data.deque;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

/**
 * Commmon tests for deques.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractDequeTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 500;

  protected void validateString(Deque<String> deque, String word) {
    // validate the initial values
    log.info("Deque: {}", deque);
    Assert.assertEquals(0, deque.size(), 0);
    Assert.assertTrue(deque.isEmpty());

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
      deque.pushLeft(item1);
      // validate
      Assert.assertEquals(i + 1, deque.size(), 0);
      Assert.assertFalse(deque.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque);
      }
    }

    int count = 0;
    while (!deque.isEmpty()) {
      String peek = deque.peekLeft();
      String item = deque.popLeft();
      //
      if (logInsideLoop) {
        log.info("-> Item '{}' popped.", item);
      }
      // validate
      int position = test.length - 1;
      Assert.assertEquals(test[position - count++], item);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque);
      }
    }
    log.info("-> Deque: {}", deque);

    Assert.assertNull(deque.popRight());
    Assert.assertNull(deque.peekRight());
    Assert.assertNull(deque.popLeft());
    Assert.assertNull(deque.peekLeft());
  }

  protected void validateInteger(Deque<Integer> deque, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    // validate the initial values
    log.info("Deque: {}", deque);
    Assert.assertEquals(0, deque.size(), 0);
    Assert.assertTrue(deque.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      deque.pushRight(item1);
      // validate
      Assert.assertEquals(i + 1, deque.size(), 0);
      Assert.assertFalse(deque.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque);
      }
    }
    log.info("-> Deque: {}", deque);

    while (!deque.isEmpty()) {
      Integer peek = deque.peekRight();
      Integer item = deque.popRight();
      //
      if (logInsideLoop) {
        log.info("-> Item '{}' popped.", item);
      }
      // validate
      Assert.assertEquals(--count, item, 0);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque);
      }
    }
    log.info("-> Deque: {}", deque);

    Assert.assertNull(deque.popRight());
    Assert.assertNull(deque.peekRight());
    Assert.assertNull(deque.popLeft());
    Assert.assertNull(deque.peekLeft());
  }
}
