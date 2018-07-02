package fworks.algorithms.problems.basics;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackServiceTest {

  private StackService stackService;

  @Before
  public void setUp() {
    this.stackService = new StackService();
  }

  @Test
  public void evaluateDijkstraTest() {
    double value = stackService.evaluateDijkstra("((1+2)/(6-3))");
    Assert.assertEquals(1.0, value, 0);

    double value2 =
        stackService.evaluateDijkstra("( 1 + ( ( 2 + 3 ) * ( ( 4 * 5 ) - ( 4 / 2 )  ) ) ");
    Assert.assertEquals(90, value2, 0);
  }

  @Test
  public void getBinaryRepresentationTest() {
    Assert.assertEquals("1", stackService.getBinaryRepresentation(-1));
    Assert.assertEquals("0", stackService.getBinaryRepresentation(0));
    Assert.assertEquals("1", stackService.getBinaryRepresentation(1));
    Assert.assertEquals("10", stackService.getBinaryRepresentation(2));
    Assert.assertEquals("11", stackService.getBinaryRepresentation(3));
    Assert.assertEquals("100", stackService.getBinaryRepresentation(4));
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
    Assert.assertArrayEquals(queueExpected.toArray(), reversedQueue.toArray());
    
    Assert.assertNull(stackService.reverse(null));
  }
}
