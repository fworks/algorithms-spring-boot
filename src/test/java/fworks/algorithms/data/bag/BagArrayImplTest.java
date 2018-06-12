package fworks.algorithms.data.bag;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class BagArrayImplTest extends AbstractBagTest {

  @Test
  public void testStringBag() {
    log.info("####### Testing String bag!");
    Bag<String> bag = new BagArrayImpl<String>();
    super.validateString(bag, "abcdefghijklmnopqrstuvwxyz");
  }
  
  @Test
  public void testIntegerBag() {
    log.info("####### Testing Integer bag!");
    Bag<Integer> bagInteger = new BagArrayImpl<Integer>();
    super.validateInteger(bagInteger, 50);
  }
}
