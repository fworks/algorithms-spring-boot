package fworks.algorithms.problems.balancedparentheses;


/**
 * Parentheses Service class.<br>
 * Based on the follow problem/exercise:<br>
 * Write a stack client that reads in sequence of left and right parentheses, braces, and brackets
 * from standard input and uses a stack to determine whether the sequence is properly balanced.<br>
 * For example, your program should print true for [()]{}{[()()]()} and false for [(]).
 * 
 * @author flaviolcastro
 *
 */
public interface ParenthesesService {

  /**
   * Verify if input is balanced.
   * 
   * @param input entered
   * @return true if balanced, false otherwise.
   */
  boolean isBalanced(String input);

}
