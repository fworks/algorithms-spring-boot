package fworks.algorithms.data.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class StackOptimizedArrayImplTest extends AbstractStackTest {

  @Test
  public void testStringStack() {
    log.info("####### Testing String stack!");
    Stack<String> stack = new StackOptimizedArrayImpl<String>();
    super.validateString(stack, "abcdefghijklmnopqrstuvwxyz");
  }

  @Test
  public void testIntegerStack() {
    log.info("####### Testing Integer stack!");
    Stack<Integer> stackInteger = new StackOptimizedArrayImpl<Integer>();
    super.validateInteger(stackInteger, 500);
  }
}
