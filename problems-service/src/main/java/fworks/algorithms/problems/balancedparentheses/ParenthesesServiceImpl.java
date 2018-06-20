package fworks.algorithms.problems.balancedparentheses;

import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import org.springframework.stereotype.Service;

/**
 * Parentheses Service implementation class.
 * 
 * @author flaviolcastro
 *
 */
@Service
public class ParenthesesServiceImpl implements ParenthesesService {

  private static final String PARENTHESES_LEFT = "(";
  private static final String PARENTHESES_RIGHT = ")";
  private static final String BRACES_LEFT = "{";
  private static final String BRACES_RIGHT = "}";
  private static final String BRACKETS_LEFT = "[";
  private static final String BRACKETS_RIGHT = "]";

  /*
   * (non-Javadoc)
   * 
   * @see
   * fworks.algorithms.problems.balancedparentheses.ParenthesesService#isBalanced(java.lang.String)
   */
  @Override
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

  /**
   * Verify if parentheses matches (open to close).
   * 
   * @param left parentheses
   * @param right parentheses
   * @return true, if them match<br/>
   *         false, otherwise
   */
  private boolean matchesLast(String left, String right) {
    if (PARENTHESES_LEFT.equals(left) && PARENTHESES_RIGHT.equals(right)) {
      return true;
    }
    if (BRACES_LEFT.equals(left) && BRACES_RIGHT.equals(right)) {
      return true;
    }
    if (BRACKETS_LEFT.equals(left) && BRACKETS_RIGHT.equals(right)) {
      return true;
    }
    return false;
  }
}
