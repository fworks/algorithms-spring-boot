package fworks.algorithms.problems.api;

import static org.mockito.Mockito.when;

import fworks.algorithms.problems.balancedparentheses.ParenthesesService;
import fworks.algorithms.problems.basics.StackService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProblemsControllerTest {

  private ProblemsController problemsController;

  private StackService stackService;
  private ParenthesesService paranthesesService;

  /**
   * Setting up mocking the services.
   */
  @Before
  public void setUp() {
    stackService = Mockito.mock(StackService.class);
    paranthesesService = Mockito.mock(ParenthesesService.class);
    problemsController = new ProblemsController(stackService, paranthesesService);
  }

  @Test
  public void countAllPrimesUntilNumberTest() {
    int number = 2;
    String expected = "10";
    when(stackService.getBinaryRepresentation(number)).thenReturn(expected);

    String value = problemsController.binaryRepresentation(number);
    Assert.assertEquals(expected, value);
  }

  @Test
  public void verifyBalancedParenthesesTest() {
    String input = "{{}}";
    when(paranthesesService.isBalanced(input)).thenReturn(true);

    boolean value = problemsController.verifyBalancedParentheses(input);
    Assert.assertTrue(value);
  }

}
