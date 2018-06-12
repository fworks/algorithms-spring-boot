package fworks.algorithms.data.stack;

import fworks.algorithms.data.stack.Stack;
import fworks.algorithms.data.stack.StackArrayImpl;
import org.junit.Assert;
import org.junit.Test;

public class Parentheses {

  @Test
  public void test() {
    // Write a stack client Parentheses.java that reads in sequence of left and right parentheses,
    // braces, and brackets from standard input and uses a stack to determine whether the sequence
    // is properly balanced. For example, your program should print true for [()]{}{[()()]()} and
    // false for [(]).
    Assert.assertTrue(parentesis("[()]{}{[()()]()}"));
    Assert.assertFalse(parentesis("[(])"));
  }

  public static final String PARENTHESES_LEFT = "(";
  public static final String PARENTHESES_RIGHT = ")";
  public static final String BRACES_LEFT = "{";
  public static final String BRACES_RIGHT = "}";
  public static final String BRACKETS_LEFT = "[";
  public static final String BRACKETS_RIGHT = "]";


  private boolean parentesis(String expression) {
    // validate
    if (expression == null || expression.trim().length() % 2 != 0) {
      // if null or not even size
      return false;
    }

    Stack<String> stack = new StackArrayImpl<>();
    String[] split = expression.split("");

    for (String item : split) {
      String last = stack.pop();
      if(last == null) {
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

