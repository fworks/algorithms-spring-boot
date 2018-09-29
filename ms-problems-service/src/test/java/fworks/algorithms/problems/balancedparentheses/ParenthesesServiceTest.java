package fworks.algorithms.problems.balancedparentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Parentheses Service test class.
 * 
 * @author flaviolcastro
 *
 */
public class ParenthesesServiceTest {

  private ParenthesesService parenthesesService;

  @BeforeEach
  public void setUp() {
    parenthesesService = new ParenthesesServiceImpl();
  }

  @Test
  public void isBalancedTest() {
    Assertions.assertTrue(parenthesesService.isBalanced("[()]{}{[()()]()}"));
    Assertions.assertTrue(parenthesesService.isBalanced("[()]{}"));
  }

  @Test
  public void isBalancedFalseTest() {
    Assertions.assertFalse(parenthesesService.isBalanced("[(])"));
    Assertions.assertFalse(parenthesesService.isBalanced("[()]{{})"));
    
    Assertions.assertFalse(parenthesesService.isBalanced("]["));
    
    Assertions.assertFalse(parenthesesService.isBalanced(null));
    Assertions.assertFalse(parenthesesService.isBalanced(""));
    Assertions.assertFalse(parenthesesService.isBalanced("]"));
  }

}
