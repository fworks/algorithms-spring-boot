package fworks.algorithms.data.bag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

/**
 * Commmon tests for bags.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public abstract class AbstractBagTest {

  private static final int MAX_SIZE_FOR_LOGGING_INSIDE_LOOP = 50;

  /**
   * Validate string bag.
   * 
   * @param bag
   * @param word
   */
  protected void validateString(Bag<String> bag, String word) {
    // validate the initial values
    log.info("Bag: {}", bag.toString());
    assertEquals(0, bag.size());
    assertTrue(bag.isEmpty());

    String[] test = word.trim().split("");
    //
    boolean logInsideLoop = test.length > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;

    for (int i = 0; i < test.length; i++) {
      // add an item
      String item1 = test[i];
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      bag.add(item1);
      // validate
      assertEquals(i + 1, bag.size());
      assertFalse(bag.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Bag: {}", bag.toString());
      }
    }
    log.info("-> Bag: {}", bag.toString());
    // assertTrue(test.length == bag.toArray().length);
  }

  /**
   * Validate Integer bag.
   * 
   * @param bag
   * @param count
   */
  protected void validateInteger(Bag<Integer> bag, int count) {
    //
    boolean logInsideLoop = count > MAX_SIZE_FOR_LOGGING_INSIDE_LOOP ? false : true;
    // validate the initial values
    log.info("Bag: {}", bag.toString());
    assertEquals(0, bag.size());
    assertTrue(bag.isEmpty());

    for (int i = 0; i < count; i++) {
      // add an item
      var item1 = i;
      //
      if (logInsideLoop) {
        log.info("-> Adding item: '{}'", item1);
      }
      bag.add(item1);
      // validate
      assertEquals(i + 1, bag.size());
      assertFalse(bag.isEmpty());
      //
      if (logInsideLoop) {
        log.info("-> Bag: {}", bag.toString());
      }
    }
    log.info("-> Bag: {}", bag.toString());
  }

  /**
   * Get the implementation class for default/common tests.
   * 
   * @return
   */
  abstract Class<?> getBagImplementationClass();

  /**
   * Get a new instance of the implementation.
   * 
   * @return
   */
  private Bag<?> getNewInstance() {
    try {
      return (Bag<?>) getBagImplementationClass().getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      log.error("Error getting the instance.", e);
      fail("Error getting the instance.");
    }
    return null;
  }
  
  /**
   * Test with data String.
   */
  @Test
  public void testBagToArray() {
    log.info("####### Testing Bag.toArray()!");
    @SuppressWarnings("unchecked")
    var bag = (Bag<String>) getNewInstance();
    String[] array = bag.toArray();
    
    // add values to array
    validateString(bag, "abcdefghijklmnopqrstuvwxyz");
    
    array = bag.toArray();
    log.info("Array: {}", Arrays.toString(array));
  }

  /**
   * Test with data String.
   */
  @Test
  public void testStringBag() {
    log.info("####### Testing String bag!");
    @SuppressWarnings("unchecked")
    var bag = (Bag<String>) getNewInstance();
    validateString(bag, "abcdefghijklmnopqrstuvwxyz");
  }

  /**
   * Test with small data Integer
   */
  @Test
  public void testIntegerSmallBag() {
    log.info("####### Testing Integer bag!");
    @SuppressWarnings("unchecked")
    var bagInteger = (Bag<Integer>) getNewInstance();
    validateInteger(bagInteger, 50);
  }

  /**
   * Test with large data Integer
   */
  @Test
  public void testIntegerLargeBag() {
    log.info("####### Testing Integer bag!");
    @SuppressWarnings("unchecked")
    var bagInteger = (Bag<Integer>) getNewInstance();
    validateInteger(bagInteger, 5000);
  }
}
