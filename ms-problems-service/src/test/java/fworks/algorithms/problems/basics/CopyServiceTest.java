package fworks.algorithms.problems.basics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.bag.BagArrayImpl;
import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;

public class CopyServiceTest {

  private CopyService copyService;

  @BeforeEach
  public void setUp() {
    this.copyService = new CopyService();
  }

  @Test
  public void copyQueueTest() throws Exception {
    Queue<String> queue = new QueueArrayImpl<>();
    queue.enqueue("A");
    queue.enqueue("B");
    queue.enqueue("C");

    Queue<String> copied = copyService.copyQueue(queue);
    Assertions.assertArrayEquals(queue.toArray(), copied.toArray());
  }

  @Test
  public void copyQueueExceptionTest() {
    assertThrows(Exception.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        copyService.copyQueue(null);
      }
    });
  }

  @Test
  public void copyStackTest() throws Exception {
    Stack<String> stack = new StackArrayImpl<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");

    Stack<String> copied = copyService.copyStack(stack);
    Assertions.assertArrayEquals(stack.toArray(), copied.toArray());
  }

  @Test
  public void copyStackExceptionTest() throws Exception {
    assertThrows(Exception.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        copyService.copyStack(null);
      }
    });
  }

  @Test
  public void copyBagTest() throws Exception {
    Bag<String> bag = new BagArrayImpl<>();
    bag.add("A");
    bag.add("B");
    bag.add("C");

    Bag<String> copied = copyService.copyBag(bag);
    Assertions.assertArrayEquals(bag.toArray(), copied.toArray());
  }

  @Test
  public void copyBagExceptionTest() throws Exception {
    assertThrows(Exception.class, new Executable() {

      @Override
      public void execute() throws Throwable {
        copyService.copyBag(null);
      }
    });
  }


}
