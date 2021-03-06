package fworks.algorithms.problems.basics;

import fworks.algorithms.data.queue.Queue;
import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import fworks.algorithms.data.stack.StackLinkedListImpl;
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
  public String getBinaryRepresentation(int integer) {
    //
    log.debug("Integer: {}", integer);
    //
    if (integer < 0) {
      integer = -integer;
    }
    if (integer == 0) {
      return "0";
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
    while (!stack.isEmpty()) {
      stringBuilder.append(stack.pop());
    }
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

  /**
   * Evaluate Dijkstra.
   * 
   * @param equation to be evaluated
   * @return value
   */
  public double evaluateDijkstra(String equation) {
    String[] split = equation.replace(" ", "").split("");

    Stack<String> operators = new StackLinkedListImpl<>();
    Stack<Double> values = new StackLinkedListImpl<>();

    for (String string : split) {

      // if (
      if ("(".equals(string)) {
        continue;
      }

      // if operator
      if ("+".equals(string) || "-".equals(string) || "*".equals(string) || "/".equals(string)) {
        operators.push(string);
        continue;
      }

      // if )
      if (")".equals(string)) {

        // get the last value
        Double value = values.pop();
        // get the last operator
        String op = operators.pop();
        // execute the operation
        if ("+".equals(op)) {
          value = values.pop() + value;
        } else if ("-".equals(op)) {
          value = values.pop() - value;
        } else if ("*".equals(op)) {
          value = values.pop() * value;
        } else if ("/".equals(op)) {
          value = values.pop() / value;
        }
        values.push(value);
        continue;
      }

      // values
      values.push(Double.parseDouble(string));
    }
    return values.pop();
  }
}
