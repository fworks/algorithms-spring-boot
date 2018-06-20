package fworks.algorithms.problems.api;

import fworks.algorithms.problems.balancedparentheses.ParenthesesService;
import fworks.algorithms.problems.basics.StackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DataStructure Api Rest Controller.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
@RestController
@RequestMapping(value = DataStructureController.API)
public class DataStructureController {

  protected static final String API = "/dataStructure";

  private StackService stackService;
  private ParenthesesService paranthesesService;

  @Autowired
  public DataStructureController(StackService stackService, ParenthesesService paranthesesService) {
    this.stackService = stackService;
    this.paranthesesService = paranthesesService;
  }

  /**
   * Api method which receive a integer number and retrieve the binary representation of the same.
   * 
   * @param number integer
   * @return binary representation string
   */
  @PostMapping("/binaryRepresentation")
  public ResponseEntity<?> binaryRepresentation(Integer number) {
    try {
      String result = stackService.getBinaryRepresentation(number);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  /**
   * Api method which verify if an input with parentheses is balanced.
   * @param parenthesesInput to be verified
   * @return true if balanced, false otherwise
   */
  @PostMapping("/verifyBalancedParentheses")
  public ResponseEntity<?> verifyBalancedParentheses(String parenthesesInput) {
    try {
      boolean result = paranthesesService.isBalanced(parenthesesInput);
      return ResponseEntity.ok(result);
    } catch (Exception e) {
      log.error("Error", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
