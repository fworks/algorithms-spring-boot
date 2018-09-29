package fworks.algorithms.data.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import lombok.extern.log4j.Log4j2;

/**
 * Commmon tests for stacks.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractStackTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 50;

  protected void validateString(Stack<String> stack, String word) {
    // validate the initial values
    log.info("Stack: {}", stack.toString());
    assertEquals(0, stack.size());
    assertTrue(stack.isEmpty());

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
      stack.push(item1);
      // validate
      assertEquals(i + 1, stack.size());
      assertFalse(stack.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack.toString());
      }
    }

    int count = 0;
    while (!stack.isEmpty()) {
      String peek = stack.peek();
      String item = stack.pop();
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
        log.info("-> Stack: {}", stack.toString());
      }
    }
    log.info("-> Stack: {}", stack.toString());

    assertNull(stack.pop());
    assertNull(stack.peek());
  }

  protected void validateInteger(Stack<Integer> stack, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    // validate the initial values
    log.info("Stack: {}", stack);
    assertEquals(0, stack.size());
    assertTrue(stack.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      stack.push(item1);
      // validate
      assertEquals(i + 1, stack.size());
      assertFalse(stack.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack.toString());
      }
    }
    log.info("-> Stack: {}", stack.toString());

    while (!stack.isEmpty()) {
      Integer peek = stack.peek();
      Integer item = stack.pop();
      //
      if (logInsideLoop) {
        log.info("-> Item '{}' popped.", item);
      }
      // validate
      assertEquals(--count, item.intValue());
      assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack);
      }
    }
    log.info("-> Stack: {}", stack.toString());

    assertNull(stack.pop());
    assertNull(stack.peek());
  }
  
}
