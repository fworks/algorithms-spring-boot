package fworks.algorithms.data;

/**
 * Represents a data structure.
 * 
 * @author flaviolcastro
 *
 * @param <T> item
 */
public interface DataStructure<T> extends Iterable<T> {

  /**
   * Verify if data structure is empty.
   * 
   * @return true if empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Get the number of items in the data structure.
   * 
   * @return number of items.
   */
  int size();

  /**
   * Print a version of data structure.
   * 
   * @param separator between the values
   * @return printable string
   */
  default String toString(String separator) {
    String string = "";
    if (!isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      // for each item
      this.forEach(t -> {
        // print the item
        stringBuilder.append(t);
        // adds the separator
        stringBuilder.append(separator);
      });
      string = stringBuilder.toString();
      // remove the last separator
      string = string.substring(0, string.length() - separator.length());
    }
    return string;
  }

  /**
   * Return an array of the item of the bag.
   * 
   * @return array of T if not empty,<br/>
   *         null otherwise
   */
  T[] toArray();
}
