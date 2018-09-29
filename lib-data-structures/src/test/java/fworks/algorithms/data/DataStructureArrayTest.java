package fworks.algorithms.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DataStructureArrayTest {

  DataStructureArray<String> optimizedArray;

  @BeforeEach
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
    assertEquals(size, this.optimizedArray.array.length);

    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(false);
    // array shouldn't change
    assertEquals(size, this.optimizedArray.array.length);

    // test decreasing for valid size
    
    // first increase the size
    this.optimizedArray.increaseArraySize(true);
    assertEquals(1, this.optimizedArray.array.length);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(true);
    // array should change
    assertEquals(0, this.optimizedArray.array.length);

    // first increase the size
    this.optimizedArray.increaseArraySize(true);
    assertEquals(1, this.optimizedArray.array.length);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(false);
    // array should change
    assertEquals(0, this.optimizedArray.array.length);

    // first increase the size
    this.optimizedArray.increaseArraySize(false);
    assertEquals(1, this.optimizedArray.array.length);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(false);
    // array should change
    assertEquals(0, this.optimizedArray.array.length);

  }
  
  
  
  @Test
  public void testIncreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test increasing
    this.optimizedArray.increaseArraySize(true);
    // array should change
    assertEquals(size + 1, this.optimizedArray.array.length);
    
    // test increasing
    this.optimizedArray.increaseArraySize(false);
    // array should change
    assertEquals(size + 2, this.optimizedArray.array.length);
  }
}
