package fworks.algorithms.problems.api;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import fworks.algorithms.problems.balancedparentheses.ParenthesesService;
import fworks.algorithms.problems.basics.StackService;

@ExtendWith(MockitoExtension.class)
public class ProblemsControllerTest {

  private ProblemsController problemsController;

  private StackService stackService;
  private ParenthesesService paranthesesService;

  /**
   * Setting up mocking the services.
   */
  @BeforeEach
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
    Assertions.assertEquals(expected, value);
  }

  @Test
  public void verifyBalancedParenthesesTest() {
    String input = "{{}}";
    when(paranthesesService.isBalanced(input)).thenReturn(true);

    boolean value = problemsController.verifyBalancedParentheses(input);
    Assertions.assertTrue(value);
  }

}
