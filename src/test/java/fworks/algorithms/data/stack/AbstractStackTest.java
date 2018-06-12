package fworks.algorithms.data.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

/**
 * Commmon tests for stacks.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractStackTest {

  protected void validateString(Stack<String> stack, String word) {
    // validate the initial values
    log.info("Stack: {}", stack);
    Assert.assertEquals(0, stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());

    String[] test = word.trim().split("");
    //
    boolean logInsideLoop = test.length > 1000 ? false : true;

    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      log.info("-> Adding item: '{}'", item1);
      stack.push(item1);
      // validate
      Assert.assertEquals(i + 1, stack.size(), 0);
      Assert.assertFalse(stack.isEmpty());
      log.info("-> Stack: {}", stack);
    }

    int count = 0;
    while (!stack.isEmpty()) {
      String peek = stack.peek();
      String item = stack.pop();
      log.info("-> Item '{}' popped.", item);
      // validate
      int position = test.length - 1;
      Assert.assertEquals(test[position - count++], item);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack);
      }
    }
    log.info("-> Stack: {}", stack);
    
    Assert.assertNull(stack.pop());
    Assert.assertNull(stack.peek());
  }

  protected void validateInteger(Stack<Integer> stack, int count) {
    //
    boolean logInsideLoop = count > 1000 ? false : true;

    // validate the initial values
    log.info("Stack: {}", stack);
    Assert.assertEquals(0, stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      log.info("-> Adding item: '{}'", item1);
      stack.push(item1);
      // validate
      Assert.assertEquals(i + 1, stack.size(), 0);
      Assert.assertFalse(stack.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack);
      }
    }
    log.info("-> Stack: {}", stack);

    while (!stack.isEmpty()) {
      Integer peek = stack.peek();
      Integer item = stack.pop();
      log.info("-> Item '{}' popped.", item);
      // validate
      Assert.assertEquals(--count, item, 0);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Stack: {}", stack);
      }
    }
    log.info("-> Stack: {}", stack);
    
    Assert.assertNull(stack.pop());
    Assert.assertNull(stack.peek());
  }
}