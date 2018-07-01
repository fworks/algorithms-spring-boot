package fworks.algorithms.problems.basics;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.bag.BagArrayImpl;
import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.queue.QueueArrayImpl;
import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CopyServiceTest {

  private CopyService copyService;

  @Before
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
    Assert.assertArrayEquals(queue.toArray(), copied.toArray());
  }
  
  @Test(expected = Exception.class)
  public void copyQueueExceptionTest() throws Exception {
    copyService.copyQueue(null);
  }
  
  @Test
  public void copyStackTest() throws Exception {
    Stack<String> stack = new StackArrayImpl<>();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    
    Stack<String> copied = copyService.copyStack(stack);
    Assert.assertArrayEquals(stack.toArray(), copied.toArray());
  }
  
  @Test(expected = Exception.class)
  public void copyStackExceptionTest() throws Exception {
    copyService.copyStack(null);
  }
  
  @Test
  public void copyBagTest() throws Exception {
    Bag<String> bag = new BagArrayImpl<>();
    bag.add("A");
    bag.add("B");
    bag.add("C");
    
    Bag<String> copied = copyService.copyBag(bag);
    Assert.assertArrayEquals(bag.toArray(), copied.toArray());
  }
  
  @Test(expected = Exception.class)
  public void copyBagExceptionTest() throws Exception {
    copyService.copyBag(null);
  }
  
  
}
