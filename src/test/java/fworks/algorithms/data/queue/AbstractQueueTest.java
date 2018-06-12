package fworks.algorithms.data.queue;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;

/**
 * Commmon tests for queues.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractQueueTest {

  protected void validateString(Queue<String> queue, String word) {
    // validate the initial values
    log.info("Queue: {}", queue);
    Assert.assertEquals(0, queue.size(), 0);
    Assert.assertTrue(queue.isEmpty());

    String[] test = word.trim().split("");
    //
    boolean logInsideLoop = test.length > 1000 ? false : true;
    
    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      log.info("-> Adding item: '{}'", item1);
      queue.enqueue(item1);
      // validate
      Assert.assertEquals(i + 1, queue.size(), 0);
      Assert.assertFalse(queue.isEmpty());
      log.info("-> Queue: {}", queue);
    }

    int count = 0;
    while (!queue.isEmpty()) {
      String peek = queue.peek();
      String item = queue.dequeue();
      log.info("-> Item '{}' dequeued.", item);
      Assert.assertEquals(test[count++], item);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("Queue: {}", queue);
      }
    }
    log.info("Queue: {}", queue);
    
    Assert.assertNull(queue.dequeue());
    Assert.assertNull(queue.peek());
  }

  protected void validateInteger(Queue<Integer> queue, int count) {
    //
    boolean logInsideLoop = count > 1000 ? false : true;
    // validate the initial values
    log.info("Queue: {}", queue);
    Assert.assertEquals(0, queue.size(), 0);
    Assert.assertTrue(queue.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      log.info("-> Adding item: '{}'", item1);
      queue.enqueue(item1);
      // validate
      Assert.assertEquals(i + 1, queue.size(), 0);
      Assert.assertFalse(queue.isEmpty());
      //
      if (logInsideLoop) {
        log.info("Queue: {}", queue);
      }
    }
    log.info("Queue: {}", queue);

    int position = 0;
    while (!queue.isEmpty()) {
      Integer peek = queue.peek();
      Integer item = queue.dequeue();
      log.info("-> Item '{}' dequeued.", item);
      Assert.assertEquals(position++, item, 0);
      Assert.assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Queue: {}", queue);
      }
    }
    log.info("-> Queue: {}", queue);
    
    Assert.assertNull(queue.dequeue());
    Assert.assertNull(queue.peek());
  }
}
