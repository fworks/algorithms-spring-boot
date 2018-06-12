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
    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      log.info("");
      log.info("-> Adding item: '{}'", item1);
      stack.push(item1);
      // validate
      Assert.assertEquals(i + 1, stack.size(), 0);
      Assert.assertFalse(stack.isEmpty());
      log.info("-> Stack: {}", stack);
    }

    int count = 0;
    while (!stack.isEmpty()) {
      log.info("");
      log.info("-> Popping item:");
      String item = stack.pop();
      log.info("-> Item '{}' popped.", item);
      // validate
      int position = test.length - 1;
      Assert.assertEquals(test[position - count++], item);
      log.info("-> Stack: {}", stack);
    }
  }

  protected void validateInteger(Stack<Integer> stack, int count) {
    // validate the initial values
    log.info("Stack: {}", stack);
    Assert.assertEquals(0, stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      log.info("");
      log.info("-> Adding item: '{}'", item1);
      stack.push(item1);
      // validate
      Assert.assertEquals(i + 1, stack.size(), 0);
      Assert.assertFalse(stack.isEmpty());
      log.info("-> Stack: {}", stack);
    }

    while (!stack.isEmpty()) {
      log.info("");
      log.info("-> Popping item:");
      Integer item = stack.pop();
      log.info("-> Item '{}' popped.", item);
      // validate
      Assert.assertEquals(--count, item, 0);
      log.info("-> Stack: {}", stack);
    }
  }
}
