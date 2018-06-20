package fworks.algorithms.problems.api;

import fworks.algorithms.problems.balancedparentheses.ParenthesesService;
import fworks.algorithms.problems.basics.StackService;
import javax.validation.constraints.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DataStructure Api Rest Controller.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = ProblemsController.API)
public class ProblemsController {

  protected static final String API = "/problems";
  
  protected static final String BINARY_REPRESENTATION = "/binaryRepresentation";
  protected static final String BALANCED_PARENTHESES = "/verifyBalancedParentheses";

  private StackService stackService;
  private ParenthesesService paranthesesService;

  @Autowired
  public ProblemsController(StackService stackService, ParenthesesService paranthesesService) {
    this.stackService = stackService;
    this.paranthesesService = paranthesesService;
  }

  /**
   * Api method which receive a integer number and retrieve the binary representation of the same.
   * 
   * @param number integer
   * @return binary representation string
   */
  @PostMapping(BINARY_REPRESENTATION)
  public String binaryRepresentation(@RequestParam int number) {
    log.info("Binary representation for {}.", number);
    return stackService.getBinaryRepresentation(number);
  }

  /**
   * Api method which verify if an input with parentheses is balanced.
   * 
   * @param parenthesesInput to be verified
   * @return true if balanced, false otherwise
   */
  @PostMapping(BALANCED_PARENTHESES)
  public boolean verifyBalancedParentheses(@RequestBody @NotNull String parenthesesInput) {
    log.info("Verify balanced parentheses: {}.", parenthesesInput);
    return paranthesesService.isBalanced(parenthesesInput);
  }
}
