package fworks.algorithms.data;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class DataStructureArrayTest {

  DataStructureArray<String> optimizedArray;

  @Before
  public void setUp() {
    this.optimizedArray = new DataStructureArray<>() {};
  }

  @Test
  public void testDecreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(true);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);

    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(false);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);

    // test decreasing for valid size
    
    // first increase the size
    this.optimizedArray.increaseArraySize(true);
    Assert.assertEquals(1, this.optimizedArray.array.length, 0);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(true);
    // array should change
    Assert.assertEquals(0, this.optimizedArray.array.length, 0);

    // first increase the size
    this.optimizedArray.increaseArraySize(true);
    Assert.assertEquals(1, this.optimizedArray.array.length, 0);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(false);
    // array should change
    Assert.assertEquals(0, this.optimizedArray.array.length, 0);

    // first increase the size
    this.optimizedArray.increaseArraySize(false);
    Assert.assertEquals(1, this.optimizedArray.array.length, 0);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(false);
    // array should change
    Assert.assertEquals(0, this.optimizedArray.array.length, 0);

  }
  
  
  
  @Test
  public void testIncreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test increasing
    this.optimizedArray.increaseArraySize(true);
    // array should change
    Assert.assertEquals(size + 1, this.optimizedArray.array.length, 0);
    
    // test increasing
    this.optimizedArray.increaseArraySize(false);
    // array should change
    Assert.assertEquals(size + 2, this.optimizedArray.array.length, 0);
  }
}
