package fworks.algorithms.problems;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StackService {

  /**
   * Get the binary representation of a integer number.
   * 
   * @param integer number.
   * @return String with 0 and 1
   */
  public String getBinaryRepresentation(Integer integer) {
    //
    log.debug("Integer: {}", integer);
    //
    if (integer == null) {
      return null;
    }
    // use a stack to hold the values
    Stack<Integer> stack = new StackArrayImpl<>();
    // keep dividing the number by 2
    while (integer > 0) {
      stack.push(integer % 2);
      integer = integer / 2;
    }
    // mount the binary representation
    StringBuilder stringBuilder = new StringBuilder();
    stack.forEach(t -> {
      stringBuilder.append(t);
    });
    String result = stringBuilder.toString();
    //
    log.debug("Integer: {} Binary: {}", integer, result);
    return result;
  }
  
  /**
   * Reverse a queue using a stack.
   * 
   * @param queue to be reversed.
   * @return reversed queue
   */
  public <T> Queue<T> reverse(Queue<T> queue) {
    //
    log.debug("Queue before: {}", queue);
    //
    if (queue == null) {
      return null;
    }
    // use a stack to hold the values
    Stack<T> stack = new StackArrayImpl<>();
    // keep dividing the number by 2
    while (!queue.isEmpty()) {
      stack.push(queue.dequeue());
    }
    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }
    //
    log.debug("Queue after: {}", queue);
    return queue;
  }
}
