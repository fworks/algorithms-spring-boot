package fworks.algorithms.problems.basics;

public interface StringService {

  /**
   * Verify if string is a palindrome.<br>
   * Palindrome definition: a word, phrase, or sequence that reads the same backwards as forwards,
   * e.g. madam or nurses run.
   * 
   * @param s to be checked
   * @return true, if is a palindrome,<br>
   *         false, otherwise
   */
  boolean isPalindrome(String s);


  /**
   * Verify if strings are circular shifted from another.<br>
   * A string s is a circular rotation of a string t if it matches when the characters are
   * circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC,
   * and vice versa. Detecting this condition is important in the study of genomic sequences.
   * 
   * @param s1 string one
   * @param s2 string two
   * @return true, if is a circular shifted,<br>
   *         false, otherwise
   */
  boolean isCircularShift(String s1, String s2);
  
  String reverse(String s);
}
