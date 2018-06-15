package fworks.algorithms.searching.binary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchImplTest {

  private BinarySearch binarySearch;

  @Before
  public void setUp() {
    binarySearch = new BinarySearchImpl();
  }
  
  protected void validateNotExistentKey(BinarySearch binarySearch, int key, long[] array) {
    // search for not existent key
    Assert.assertEquals(-1, binarySearch.searchLoop(key, array), 0);
    Assert.assertEquals(-1, binarySearch.searchRecursive(key, array), 0);
  }
  
  protected void validateExistentKey(BinarySearch binarySearch, long key, long[] array, int index) {
    // search for existent key
    Assert.assertEquals(index, binarySearch.searchLoop(key, array), 0);
    Assert.assertEquals(index, binarySearch.searchRecursive(key, array), 0);
  }

  @Test
  public void searchSizeOneArrayTest() {
    long[] array = {0};
    // search for not existent key
    validateNotExistentKey(binarySearch, 10, array);
    // search for existent key
    validateExistentKey(binarySearch, 0, array, 0);
  }

  @Test
  public void searchSizeTwoArrayTest() {
    long[] array = {0, 10};
    // search for not existent key
    validateNotExistentKey(binarySearch, 12, array);
    // search for existent key
    validateExistentKey(binarySearch, 0, array, 0);
    validateExistentKey(binarySearch, 10, array, 1);
  }

  @Test
  public void searchSizeThreeArrayTest() {
    long[] array = {0, 10, 25};
    // search for not existent key
    validateNotExistentKey(binarySearch, 12, array);
    // search for existent key
    validateExistentKey(binarySearch, 0, array, 0);
    validateExistentKey(binarySearch, 10, array, 1);
    validateExistentKey(binarySearch, 25, array, 2);
  }

  @Test
  public void searchArrayTest() {
    long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // search for not existent key
    validateNotExistentKey(binarySearch, 12, array);
    validateNotExistentKey(binarySearch, 0, array);
    // search for existent key
    validateExistentKey(binarySearch, 1, array, 0);
    validateExistentKey(binarySearch, 2, array, 1);
    validateExistentKey(binarySearch, 3, array, 2);
    validateExistentKey(binarySearch, 4, array, 3);
    validateExistentKey(binarySearch, 5, array, 4);
    validateExistentKey(binarySearch, 6, array, 5);
    validateExistentKey(binarySearch, 7, array, 6);
    validateExistentKey(binarySearch, 8, array, 7);
    validateExistentKey(binarySearch, 9, array, 8);
    validateExistentKey(binarySearch, 10, array, 9);
  }

  @Test
  public void searchBigArrayTest() {
    int count = 500;
    long[] array = new long[count];
    for (int i = 1; i <= count; i++) {
      array[i - 1] = i;
    }
    // search for not existent key
    validateNotExistentKey(binarySearch, 0, array);
    validateNotExistentKey(binarySearch, count + 1, array);
    // search for existent key
    validateExistentKey(binarySearch, 1, array, 0);
    validateExistentKey(binarySearch, 2, array, 1);
    validateExistentKey(binarySearch, 3, array, 2);
    validateExistentKey(binarySearch, 4, array, 3);
    validateExistentKey(binarySearch, 5, array, 4);
    validateExistentKey(binarySearch, 6, array, 5);
    validateExistentKey(binarySearch, 7, array, 6);
    validateExistentKey(binarySearch, 8, array, 7);
    validateExistentKey(binarySearch, 9, array, 8);
    validateExistentKey(binarySearch, 10, array, 9);

    validateExistentKey(binarySearch, count, array, count - 1);
  }
}
