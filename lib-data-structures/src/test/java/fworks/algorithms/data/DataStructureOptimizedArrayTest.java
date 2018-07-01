package fworks.algorithms.data;

import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Log4j2
public class DataStructureOptimizedArrayTest {

  DataStructureOptimizedArray<String> optimizedArray;

  @Before
  public void setUp() {
    this.optimizedArray = new DataStructureOptimizedArray<>() {};
  }

  @Test
  public void testDecreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(size);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);

    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(size + 1);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);

    // test decreasing for invalid size
    this.optimizedArray.decreaseArraySize(size - 1);
    // array shouldn't change if size was 0
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);
    
    // test decreasing for valid size
    
    // first increase the size
    this.optimizedArray.increaseArraySize(1);
    Assert.assertEquals(1, this.optimizedArray.array.length, 0);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(0);
    // array should change
    Assert.assertEquals(0, this.optimizedArray.array.length, 0);

  }
  
  
  
  @Test
  public void testIncreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test increasing for the same size
    this.optimizedArray.increaseArraySize(size);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);

    // test increasing for invalid size
    this.optimizedArray.increaseArraySize(size - 1);
    // array shouldn't change
    Assert.assertEquals(size, this.optimizedArray.array.length, 0);
    
    // test increasing 
    this.optimizedArray.increaseArraySize(size + 1);
    // array should change
    Assert.assertEquals(size + 1, this.optimizedArray.array.length, 0);

  }
}
