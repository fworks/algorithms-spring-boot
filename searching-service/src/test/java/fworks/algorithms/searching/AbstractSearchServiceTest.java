package fworks.algorithms.searching;

import org.junit.Assert;

/**
 * Abstract test class for search service. <br/>
 * Have some common tests already implemented.
 * 
 * @author flaviolcastro
 *
 */
public abstract class AbstractSearchServiceTest {

  protected void validateNotExistentKey(SearchService searchService, int key, long[] array) {
    // search for not existent key
    Assert.assertEquals(-1, searchService.search(key, array), 0);
  }

  protected void validateExistentKey(SearchService searchService, long key, long[] array,
      int index) {
    // search for existent key
    Assert.assertEquals(index, searchService.search(key, array), 0);
  }

  protected void executeCommonTests(SearchService searchService) {
    // array length 1
    this.searchSizeOneArrayTest(searchService);
    // array length 2
    this.searchSizeTwoArrayTest(searchService);
    // array length 3
    this.searchSizeThreeArrayTest(searchService);
    // array length 10
    this.searchArrayTest(searchService);
    // array length 500
    this.searchBigArrayTest(searchService);
  }

  private void searchSizeOneArrayTest(SearchService searchService) {
    long[] array = {0};
    // search for not existent key
    validateNotExistentKey(searchService, 10, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
  }

  private void searchSizeTwoArrayTest(SearchService searchService) {
    long[] array = {0, 10};
    // search for not existent key
    validateNotExistentKey(searchService, 12, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
    validateExistentKey(searchService, 10, array, 1);
  }

  private void searchSizeThreeArrayTest(SearchService searchService) {
    long[] array = {0, 10, 25};
    // search for not existent key
    validateNotExistentKey(searchService, 12, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
    validateExistentKey(searchService, 10, array, 1);
    validateExistentKey(searchService, 25, array, 2);
  }

  private void searchArrayTest(SearchService searchService) {
    long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // search for not existent key
    validateNotExistentKey(searchService, 12, array);
    validateNotExistentKey(searchService, 0, array);
    // search for existent key
    validateExistentKey(searchService, 1, array, 0);
    validateExistentKey(searchService, 2, array, 1);
    validateExistentKey(searchService, 3, array, 2);
    validateExistentKey(searchService, 4, array, 3);
    validateExistentKey(searchService, 5, array, 4);
    validateExistentKey(searchService, 6, array, 5);
    validateExistentKey(searchService, 7, array, 6);
    validateExistentKey(searchService, 8, array, 7);
    validateExistentKey(searchService, 9, array, 8);
    validateExistentKey(searchService, 10, array, 9);
  }

  private void searchBigArrayTest(SearchService searchService) {
    int count = 500;
    long[] array = new long[count];
    for (int i = 1; i <= count; i++) {
      array[i - 1] = i;
    }
    // search for not existent key
    validateNotExistentKey(searchService, 0, array);
    validateNotExistentKey(searchService, count + 1, array);
    // search for existent key
    validateExistentKey(searchService, 1, array, 0);
    validateExistentKey(searchService, 2, array, 1);
    validateExistentKey(searchService, 3, array, 2);
    validateExistentKey(searchService, 4, array, 3);
    validateExistentKey(searchService, 5, array, 4);
    validateExistentKey(searchService, 6, array, 5);
    validateExistentKey(searchService, 7, array, 6);
    validateExistentKey(searchService, 8, array, 7);
    validateExistentKey(searchService, 9, array, 8);
    validateExistentKey(searchService, 10, array, 9);

    validateExistentKey(searchService, count, array, count - 1);
  }
}
