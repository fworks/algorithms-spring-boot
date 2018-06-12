package fworks.algorithms.data.queue;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class QueueLinkedListImplTest extends AbstractQueueTest {

  @Test
  public void testStringQueue() {
    log.info("####### Testing String queue!");
    Queue<String> queue = new QueueLinkedListImpl<String>();
    super.validateString(queue, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerQueue() {
    log.info("####### Testing Integer queue!");
    Queue<Integer> queueInteger = new QueueLinkedListImpl<Integer>();
    super.validateInteger(queueInteger, 500);
  }
  
  @Test
  public void testInteger2Queue() {
    log.info("####### Testing Integer queue!");
    Queue<Integer> queueInteger = new QueueLinkedListImpl<Integer>();
    super.validateInteger(queueInteger, 50000);
  }
}
