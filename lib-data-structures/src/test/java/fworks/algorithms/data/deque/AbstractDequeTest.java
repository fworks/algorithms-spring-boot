package fworks.algorithms.data.deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import lombok.extern.log4j.Log4j2;

/**
 * Commmon tests for deques.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractDequeTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 50;

  protected void validateString(Deque<String> deque, String word) {
    // validate the initial values
    log.info("Deque: {}", deque.toString());
    assertEquals(0, deque.size());
    assertTrue(deque.isEmpty());

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
      assertEquals(i + 1, deque.size());
      assertFalse(deque.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque.toString());
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
      assertEquals(test[position - count++], item);
      assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque.toString());
      }
    }
    log.info("-> Deque: {}", deque.toString());

    assertNull(deque.popRight());
    assertNull(deque.peekRight());
    assertNull(deque.popLeft());
    assertNull(deque.peekLeft());
  }

  protected void validateInteger(Deque<Integer> deque, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    // validate the initial values
    log.info("Deque: {}", deque.toString());
    assertEquals(0, deque.size());
    assertTrue(deque.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      deque.pushRight(item1);
      // validate
      assertEquals(i + 1, deque.size());
      assertFalse(deque.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque.toString());
      }
    }
    log.info("-> Deque: {}", deque.toString());

    while (!deque.isEmpty()) {
      Integer peek = deque.peekRight();
      Integer item = deque.popRight();
      //
      if (logInsideLoop) {
        log.info("-> Item '{}' popped.", item);
      }
      // validate
      assertEquals(--count, item.intValue());
      assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Deque: {}", deque.toString());
      }
    }
    log.info("-> Deque: {}", deque.toString());

    assertNull(deque.popRight());
    assertNull(deque.peekRight());
    assertNull(deque.popLeft());
    assertNull(deque.peekLeft());
  }
}
