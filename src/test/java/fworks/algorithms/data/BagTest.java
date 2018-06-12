package fworks.algorithms.data;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.bag.BagArrayImpl;
import fworks.algorithms.data.bag.BagLinkedListImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;

@Log4j2
public class BagTest {

  @Test
  public void testBag() {
    Bag<String> bag = new BagArrayImpl<String>();
    commonTest(bag);
  }

  @Test
  public void testBagLinkedList() {
    Bag<String> bag = new BagLinkedListImpl<String>();
    commonTest(bag);
  }

  private void commonTest(Bag<String> bag) {
    log.info("Implementation: {}", bag.getClass().getSimpleName());
    
    log.info("Bag: {}", bag);
    Assert.assertEquals(0, bag.size(), 0);
    Assert.assertTrue(bag.isEmpty());
    
    String item1 = "a";
    log.info("-> Adding '{}' to bag: {}", item1, bag);
    bag.add(item1);
    log.info("Bag: {}", bag);
    Assert.assertEquals(1, bag.size(), 0);
    Assert.assertFalse(bag.isEmpty());
    
    String item2 = "b";
    log.info("-> Adding '{}' to bag: {}", item2, bag);
    bag.add(item2);
    log.info("Bag: {}", bag);
    Assert.assertEquals(2, bag.size(), 0);
    Assert.assertFalse(bag.isEmpty());
    
    String item3 = "c";
    log.info("-> Adding '{}' to bag: {}", item3, bag);
    bag.add(item3);
    log.info("Bag: {}", bag);
    Assert.assertEquals(3, bag.size(), 0);
    Assert.assertFalse(bag.isEmpty());
  }
}
