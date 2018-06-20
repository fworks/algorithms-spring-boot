package fworks.algorithms.problems.balancedparentheses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Parentheses Service test class.
 * 
 * @author flaviolcastro
 *
 */
public class ParenthesesServiceTest {

  private ParenthesesService parenthesesService;

  @Before
  public void setUp() {
    parenthesesService = new ParenthesesServiceImpl();
  }

  @Test
  public void isBalancedTest() {
    Assert.assertTrue(parenthesesService.isBalanced("[()]{}{[()()]()}"));
    Assert.assertTrue(parenthesesService.isBalanced("[()]{}"));
  }

  @Test
  public void isBalancedFalseTest() {
    Assert.assertFalse(parenthesesService.isBalanced("[(])"));
    Assert.assertFalse(parenthesesService.isBalanced("[()]{{})"));
    
    Assert.assertFalse(parenthesesService.isBalanced("]["));
    
    Assert.assertFalse(parenthesesService.isBalanced(null));
    Assert.assertFalse(parenthesesService.isBalanced(""));
    Assert.assertFalse(parenthesesService.isBalanced("]"));
  }

}
