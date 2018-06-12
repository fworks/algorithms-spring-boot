package fworks.algorithms.data;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import fworks.algorithms.data.queue.QueueLinkedListImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;

@Log4j2
public class QueueTest {

  @Test
  public void testQueue() {
    Queue<String> queue = new QueueArrayImpl<String>();
    commonTest(queue);
  }

  @Test
  public void testQueueLinkedList() {
    Queue<String> queue = new QueueLinkedListImpl<String>();
    commonTest(queue);
  }

  private void commonTest(Queue<String> queue) {
    log.info("Implementation: {}", queue.getClass().getSimpleName());
    
    log.info("Queue: {}", queue);
    Assert.assertEquals(0, queue.size(), 0);
    Assert.assertTrue(queue.isEmpty());
    
    String item1 = "a";
    log.info("-> Adding '{}' to queue: {}", item1, queue);
    queue.enqueue(item1);
    log.info("Queue: {}", queue);
    Assert.assertEquals(1, queue.size(), 0);
    Assert.assertFalse(queue.isEmpty());

    String item2 = "b";
    log.info("-> Adding '{}' to queue: {}", item2, queue);
    queue.enqueue(item2);
    log.info("Queue: {}", queue);
    Assert.assertEquals(2, queue.size(), 0);
    Assert.assertFalse(queue.isEmpty());
    
    String item3 = "c";
    log.info("-> Adding '{}' to queue: {}", item3, queue);
    queue.enqueue(item3);
    log.info("Queue: {}", queue);
    Assert.assertEquals(3, queue.size(), 0);
    Assert.assertFalse(queue.isEmpty());
    
    log.info("-> Dequeing from queue: {}", queue);
    String dequeue = queue.dequeue();
    log.info("Queue: {}", queue);
    Assert.assertEquals(item1, dequeue);
    Assert.assertEquals(2, queue.size(), 0);
    Assert.assertFalse(queue.isEmpty());
    
    log.info("-> Dequeing from queue: {}", queue);
    dequeue = queue.dequeue();
    log.info("Queue: {}", queue);
    Assert.assertEquals(item2, dequeue);
    Assert.assertEquals(1, queue.size(), 0);
    Assert.assertFalse(queue.isEmpty());

    log.info("-> Dequeing from queue: {}", queue);
    dequeue = queue.dequeue();
    log.info("Queue: {}", queue);
    Assert.assertEquals(item3, dequeue);
    Assert.assertEquals(0, queue.size(), 0);
    Assert.assertTrue(queue.isEmpty());
  }

}
