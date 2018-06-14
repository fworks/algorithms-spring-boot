package fworks.algorithms.basics;

import fworks.algorithms.data.bag.Bag;
import fworks.algorithms.data.queue.Queue;

/**
 * Implements few number related operations.
 * 
 * @author flaviolcastro
 *
 */
public interface NumberService {

  /**
   * Absolute value of a number.
   * 
   * @param number input
   * @return absolute value
   */
  long getAbs(long number);

  /**
   * Absolute value of a number.
   * 
   * @param number input
   * @return absolute value
   */
  double getAbs(double number);

  /**
   * Verify if number is a prime number.<br/>
   * Prime definition: An integer greater than one is called a prime number if its only positive
   * divisors (factors) are one and itself.
   * 
   * @param number to check
   * @return true if prime, false otherwise
   */
  boolean isPrime(long number);

  /**
   * Find all prime number until a passed number.
   * 
   * @param number max
   * @return Bag with the numbers
   */
  Bag<Integer> findAllPrimes(long number);

  /**
   * Count all prime numbers until a passed number.
   * 
   * @param number max
   * @return number of primes
   */
  long countAllPrimes(long number);

  /**
   * Factor a number.
   * 
   * @param number to be factored.
   * @return Queue with the factors of the number.
   */
  Queue<Long> factor(long number);

  /**
   * Calculate the square root for perfect square root.
   * 
   * @param number to calculate
   * @return square root value if number is a perfect square root,<br/>
   *         NaN if not a perfect square root.
   */
  double perfectSquareRoot(long number);

  /**
   * Calculate the square root using Newton's method.<br/>
   * Note: Copied from the book.
   * 
   * @param number to calculate
   * @return square root value or approximated value
   */
  double squareRootNewtons(double number);

  /**
   * Calculate the hypotenuse of a right triangle. H=sqrt(a2+b2)
   * 
   * @param sideA side A
   * @param sideB side B
   * @return hypotenuse value
   */
  double getRightTrianguleHypotenuse(double sideA, double sideB);

  /**
   * Calculate the area of a right triangule.<br/>
   * A = ab/2
   * 
   * @param sideA side A
   * @param sideB side B
   * @return area value
   */
  double getRightTrianguleArea(double sideA, double sideB);

  /**
   * Calculate the perimeter of a right triangule.<br/>
   * P = a+b+sqrt(a2+b2)
   * 
   * @param sideA side A
   * @param sideB side B
   * @return perimeter value
   */
  double getRightTriangulePerimeter(double sideA, double sideB);

}
