package fworks.algorithms.data.queue;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class QueueArrayImplTest extends AbstractQueueTest {

  @Test
  public void testStringQueue() {
    log.info("####### Testing String queue!");
    Queue<String> queue = new QueueArrayImpl<String>();
    super.validateString(queue, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerQueue() {
    log.info("####### Testing Integer queue!");
    Queue<Integer> queueInteger = new QueueArrayImpl<Integer>();
    super.validateInteger(queueInteger, 500);
  }
}
