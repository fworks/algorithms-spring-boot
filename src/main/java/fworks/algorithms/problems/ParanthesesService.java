package fworks.algorithms.problems;

import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import org.springframework.stereotype.Service;

/**
 * Parentheses Service class.<br/>
 * Based on the follow problem/exercise:<br/>
 * Write a stack client that reads in sequence of left and right parentheses, braces, and brackets
 * from standard input and uses a stack to determine whether the sequence is properly balanced.<br/>
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 * 
 * @author flaviolcastro
 *
 */
@Service
public class ParanthesesService {

  private static final String PARENTHESES_LEFT = "(";
  private static final String PARENTHESES_RIGHT = ")";
  private static final String BRACES_LEFT = "{";
  private static final String BRACES_RIGHT = "}";
  private static final String BRACKETS_LEFT = "[";
  private static final String BRACKETS_RIGHT = "]";

  /**
   * Verify if input is balanced.
   * 
   * @param input entered
   * @return true if balanced, false otherwise.
   */
  public boolean isBalanced(String input) {
    // validate the input
    if (validateInput(input)) {

      Stack<String> stack = new StackArrayImpl<>();
      String[] split = input.split("");

      for (String item : split) {
        String last = stack.pop();
        if (last == null) {
          stack.push(item);
          continue;
        }
        if (!matchesLast(last, item)) {
          stack.push(last);
          stack.push(item);
        }
      }
      return stack.isEmpty();


    }
    return false;
  }

  /**
   * Validate the input.
   * 
   * @param input string entered
   * @return true if valid, false otherwise
   */
  private boolean validateInput(String input) {
    // validate not null

    // validate
    if (input == null || input.trim().length() % 2 != 0) {
      // if null or not even size
      return false;
    }
    return true;
  }

  private boolean matchesLast(String item, String last) {
    if (PARENTHESES_LEFT.equals(item) && PARENTHESES_RIGHT.equals(last)) {
      return true;
    }
    if (BRACES_LEFT.equals(item) && BRACES_RIGHT.equals(last)) {
      return true;
    }
    if (BRACKETS_LEFT.equals(item) && BRACKETS_RIGHT.equals(last)) {
      return true;
    }
    return false;
  }
}
