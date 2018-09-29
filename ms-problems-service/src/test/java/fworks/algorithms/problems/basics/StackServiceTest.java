package fworks.algorithms.problems.basics;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackServiceTest {

  private StackService stackService;

  @BeforeEach
  public void setUp() {
    this.stackService = new StackService();
  }

  @Test
  public void evaluateDijkstraTest() {
    double value = stackService.evaluateDijkstra("((1+2)/(6-3))");
    Assertions.assertEquals(1.0, value);

    double value2 =
        stackService.evaluateDijkstra("( 1 + ( ( 2 + 3 ) * ( ( 4 * 5 ) - ( 4 / 2 )  ) ) ");
    Assertions.assertEquals(90, value2);
  }

  @Test
  public void getBinaryRepresentationTest() {
    Assertions.assertEquals("1", stackService.getBinaryRepresentation(-1));
    Assertions.assertEquals("0", stackService.getBinaryRepresentation(0));
    Assertions.assertEquals("1", stackService.getBinaryRepresentation(1));
    Assertions.assertEquals("10", stackService.getBinaryRepresentation(2));
    Assertions.assertEquals("11", stackService.getBinaryRepresentation(3));
    Assertions.assertEquals("100", stackService.getBinaryRepresentation(4));
  }

  @Test
  public void reverseTest() {
    Queue<String> queue = new QueueArrayImpl<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    Queue<String> queueExpected = new QueueArrayImpl<>();
    queueExpected.enqueue("C");
    queueExpected.enqueue("B");
    queueExpected.enqueue("A");

    Queue<String> reversedQueue = stackService.reverse(queue);
    Assertions.assertArrayEquals(queueExpected.toArray(), reversedQueue.toArray());
    
    Assertions.assertNull(stackService.reverse(null));
  }
}
