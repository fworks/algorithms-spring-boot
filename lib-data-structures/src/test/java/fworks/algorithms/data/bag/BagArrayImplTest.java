package fworks.algorithms.data.bag;

import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

/**
 * Test for BagArrayImpl.
 * 
 * @author flaviolcastro
 *
 */
@Log4j2
public class BagArrayImplTest extends AbstractBagTest {

  @Override
  Class<?> getBagImplementationClass() {
    return BagArrayImpl.class;
  }
  
  /**
   * Test with super large data Integer
   */
  @Test
  public void testIntegerSuperLargeBag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagArrayImpl<>();
    validateInteger(bagInteger, 5000);
  }

}
