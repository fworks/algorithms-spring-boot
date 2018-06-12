package fworks.algorithms.data.bag;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class BagOptimizedArrayImplTest extends AbstractBagTest {

  @Test
  public void testStringBag() {
    log.info("####### Testing String bag!");
    Bag<String> bag = new BagOptimizedArrayImpl<String>();
    super.validateString(bag, "abcdefghijklmnopqrstuvwxyz");
  }

  @Test
  public void testIntegerBag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagOptimizedArrayImpl<Integer>();
    super.validateInteger(bagInteger, 500);
  }
  
  @Test
  public void testInteger2Bag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagOptimizedArrayImpl<Integer>();
    super.validateInteger(bagInteger, 50000);
  }
}
