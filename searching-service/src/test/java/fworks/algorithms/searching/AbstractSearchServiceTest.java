package fworks.algorithms.searching;

import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract test class for search service. <br>
 * Have some common tests already implemented.
 * 
 * @author flaviolcastro
 *
 */
public abstract class AbstractSearchServiceTest {

  /**
   * Validate the search service against an non existent key.
   * 
   * @param searchService to be tested
   * @param key to be found
   * @param array to be searched
   */
  protected void validateNotExistentKey(SearchService searchService, int key, long[] array) {
    // search for not existent key
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(array) //
        .key(key) //
        .build();
    SearchResponse searchResponse = searchService.search(searchRequest);
    Assert.assertEquals(-1, searchResponse.getIndex(), 0);
  }

  /**
   * Validate the search service against an existent key.
   * 
   * @param searchService to be tested
   * @param key to be found
   * @param array to be searched
   * @param index of the key on the array
   */
  protected void validateExistentKey(SearchService searchService, long key, long[] array,
      int index) {
    // search for existent key
    SearchRequest searchRequest = SearchRequest.builder() //
        .array(array) //
        .key(key) //
        .build();
    SearchResponse searchResponse = searchService.search(searchRequest);
    Assert.assertEquals(index, searchResponse.getIndex(), 0);
  }

  /**
   * Get the search service to be tested.
   * 
   * @return SearchService
   */
  protected abstract SearchService getSearchService();

  /**
   * Search on an array length 1.
   */
  @Test
  public void searchSizeOneArrayTest() {
    SearchService searchService = getSearchService();
    long[] array = {0};
    // search for not existent key
    validateNotExistentKey(searchService, 10, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
  }

  /**
   * Search on an array length 2.
   */
  @Test
  public void searchSizeTwoArrayTest() {
    SearchService searchService = getSearchService();
    long[] array = {0, 10};
    // search for not existent key
    validateNotExistentKey(searchService, 12, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
    validateExistentKey(searchService, 10, array, 1);
  }

  /**
   * Search on an array length 3.
   */
  @Test
  public void searchSizeThreeArrayTest() {
    SearchService searchService = getSearchService();
    long[] array = {0, 10, 25};
    // search for not existent key
    validateNotExistentKey(searchService, 12, array);
    // search for existent key
    validateExistentKey(searchService, 0, array, 0);
    validateExistentKey(searchService, 10, array, 1);
    validateExistentKey(searchService, 25, array, 2);
  }

  /**
   * Search on an array length 10.
   */
  @Test
  public void searchArrayTest() {
    SearchService searchService = getSearchService();
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

  /**
   * Search on an array length 500.
   */
  @Test
  public void searchBigArrayTest() {
    SearchService searchService = getSearchService();
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
