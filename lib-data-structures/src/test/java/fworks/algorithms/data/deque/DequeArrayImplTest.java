package fworks.algorithms.data.deque;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
public class DequeArrayImplTest extends AbstractDequeTest {

  @Test
  public void testStringDeque() {
    log.info("####### Testing String deque!");
    Deque<String> deque = new DequeArrayImpl<String>();
    super.validateString(deque, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerDeque() {
    log.info("####### Testing Integer deque!");
    Deque<Integer> dequeInteger = new DequeArrayImpl<Integer>();
    super.validateInteger(dequeInteger, 50);
  }
  
  @Test
  public void testInteger2Deque() {
    log.info("####### Testing Integer deque!");
    Deque<Integer> dequeInteger = new DequeArrayImpl<Integer>();
    super.validateInteger(dequeInteger, 5000);
  }
}
