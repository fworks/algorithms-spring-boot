package fworks.algorithms.data;

import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import fworks.algorithms.data.stack.StackLinkedListImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;

@Log4j2
public class StackTest {

  @Test
  public void testStack() {
    Stack<String> stack = new StackArrayImpl<String>();
    commonTest(stack);
  }

  @Test
  public void testStackLinkedList() {
    Stack<String> stack = new StackLinkedListImpl<String>();
    commonTest(stack);
  }

  private void commonTest(Stack<String> stack) {
    log.info("Implementation: {}", stack.getClass().getSimpleName());
    
    log.info("Stack: {}", stack);
    Assert.assertEquals(0, stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());
    
    String item1 = "a";
    log.info("-> Adding '{}' to stack: {}", item1, stack);
    stack.push(item1);
    log.info("Stack: {}", stack);
    Assert.assertEquals(1, stack.size(), 0);
    Assert.assertFalse(stack.isEmpty());
    
    String item2 = "b";
    log.info("-> Adding '{}' to stack: {}", item2, stack);
    stack.push(item2);
    log.info("Stack: {}", stack);
    Assert.assertEquals(2, stack.size(), 0);
    Assert.assertFalse(stack.isEmpty());

    String item3 = "c";
    log.info("-> Adding '{}' to stack: {}", item3, stack);
    stack.push(item3);
    log.info("Stack: {}", stack);
    Assert.assertEquals(3, stack.size(), 0);
    Assert.assertFalse(stack.isEmpty());
    
    log.info("-> Removing item from stack: {}", stack);
    String popped = stack.pop();
    log.info("Stack: {}", stack);
    Assert.assertEquals(item3, popped);
    Assert.assertEquals(2, stack.size(), 0);
    Assert.assertFalse(stack.isEmpty());

    log.info("-> Removing item from stack: {}", stack);
    popped = stack.pop();
    log.info("Stack: {}", stack);
    Assert.assertEquals(item2, popped);
    Assert.assertEquals(1, stack.size(), 0);
    Assert.assertFalse(stack.isEmpty());
    
    log.info("-> Removing item from stack: {}", stack);
    popped = stack.pop();
    log.info("Stack: {}", stack);
    Assert.assertEquals(item1, popped);
    Assert.assertEquals(0, stack.size(), 0);
    Assert.assertTrue(stack.isEmpty());
  }
}
