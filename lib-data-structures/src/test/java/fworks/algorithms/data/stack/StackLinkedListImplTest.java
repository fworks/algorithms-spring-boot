package fworks.algorithms.data.stack;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class StackLinkedListImplTest extends AbstractStackTest {

  @Test
  public void testStringStack() {
    log.info("####### Testing String stack!");
    Stack<String> stack = new StackLinkedListImpl<String>();
    super.validateString(stack, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerStack() {
    log.info("####### Testing Integer stack!");
    Stack<Integer> stackInteger = new StackLinkedListImpl<Integer>();
    super.validateInteger(stackInteger, 500);
  }
  
  @Test
  public void testInteger2Stack() {
    log.info("####### Testing Integer stack!");
    Stack<Integer> stackInteger = new StackLinkedListImpl<Integer>();
    super.validateInteger(stackInteger, 5000);
  }
}
