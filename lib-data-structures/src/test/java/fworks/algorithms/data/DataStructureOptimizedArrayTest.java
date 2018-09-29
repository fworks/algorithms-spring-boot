package fworks.algorithms.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DataStructureOptimizedArrayTest {

  DataStructureOptimizedArray<String> optimizedArray;

  @BeforeEach
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
    assertEquals(size, this.optimizedArray.array.length);

    // test decreasing for the same size
    this.optimizedArray.decreaseArraySize(size + 1);
    // array shouldn't change
    assertEquals(size, this.optimizedArray.array.length);

    // test decreasing for invalid size
    this.optimizedArray.decreaseArraySize(size - 1);
    // array shouldn't change if size was 0
    assertEquals(size, this.optimizedArray.array.length);
    
    // test decreasing for valid size
    
    // first increase the size
    this.optimizedArray.increaseArraySize(1);
    assertEquals(1, this.optimizedArray.array.length);
    
    // now decreaset
    this.optimizedArray.decreaseArraySize(0);
    // array should change
    assertEquals(0, this.optimizedArray.array.length);

  }
  
  
  
  @Test
  public void testIncreaseArray() {
    log.info(this.optimizedArray.array);
    var size = this.optimizedArray.array.length;
    
    // test increasing for the same size
    this.optimizedArray.increaseArraySize(size);
    // array shouldn't change
    assertEquals(size, this.optimizedArray.array.length);

    // test increasing for invalid size
    this.optimizedArray.increaseArraySize(size - 1);
    // array shouldn't change
    assertEquals(size, this.optimizedArray.array.length);
    
    // test increasing 
    this.optimizedArray.increaseArraySize(size + 1);
    // array should change
    assertEquals(size + 1, this.optimizedArray.array.length);

  }
}
