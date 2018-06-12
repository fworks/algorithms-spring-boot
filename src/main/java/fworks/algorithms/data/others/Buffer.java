package fworks.algorithms.data.others;

/**
 * Buffer.<br/>
 * Based on: Develop a data type for a buffer in a text editor that implements the following API.
 * Hint: Use two stacks
 * 
 * @author flaviolcastro
 *
 */
public interface Buffer {

  /**
   * Insert c at the cursor position.
   * 
   * @param c char to be inserted
   */
  void insert(char c);

  /**
   * Character at the cursor position.
   * 
   * @return char at position
   */
  char get();

  /**
   * Delete and return the character at the cursor.
   * 
   * @return char at position
   */
  char delete();

  /**
   * Move the cursor k positions to the left.
   * 
   * @param k number of positions
   */
  void left(int k);

  /**
   * Move the cursor k positions to the right.
   * 
   * @param k number of positions
   */
  void right(int k);

  /**
   * Number of characters in the buffer.
   * 
   * @return
   */
  int size();

}
