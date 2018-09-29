package fworks.algorithms.data.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import lombok.extern.log4j.Log4j2;

/**
 * Commmon tests for queues.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractQueueTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 50;

  protected void validateString(Queue<String> queue, String word) {
    // validate the initial values
    log.info("Queue: {}", queue.toString());
    assertEquals(0, queue.size());
    assertTrue(queue.isEmpty());

    String[] test = word.trim().split("");
    //
    boolean logInsideLoop = test.length > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      queue.enqueue(item1);
      // validate
      assertEquals(i + 1, queue.size());
      assertFalse(queue.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Queue: {}", queue.toString());
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      String peek = queue.peek();
      String item = queue.dequeue();
      log.info("-> Item '{}' dequeued.", item);
      assertEquals(test[count++], item);
      assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("Queue: {}", queue.toString());
      }
    }
    log.info("Queue: {}", queue.toString());

    assertNull(queue.dequeue());
    assertNull(queue.peek());
  }

  protected void validateInteger(Queue<Integer> queue, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;
    // validate the initial values
    log.info("Queue: {}", queue);
    assertEquals(0, queue.size());
    assertTrue(queue.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      Integer item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      queue.enqueue(item1);
      // validate
      assertEquals(i + 1, queue.size());
      assertFalse(queue.isEmpty());
      //
      if (logInsideLoop) {
        log.info("Queue: {}", queue.toString());
      }
    }
    log.info("Queue: {}", queue.toString());

    int position = 0;
    while (!queue.isEmpty()) {
      Integer peek = queue.peek();
      Integer item = queue.dequeue();
      //
      if (logInsideLoop) {
        log.info("-> Item '{}' dequeued.", item);
      }
      assertEquals(position++, item.intValue());
      assertEquals(peek, item);
      //
      if (logInsideLoop) {
        log.info("-> Queue: {}", queue.toString());
      }
    }
    log.info("-> Queue: {}", queue.toString());

    assertNull(queue.dequeue());
    assertNull(queue.peek());
  }
}
